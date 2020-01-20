package cn.enjoy.controller;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@RequestMapping("/prodcut")
public class ProductController {

    @Resource
    private IProductService iProductService;

//    import com.netflix.discovery.DiscoveryClient;
//    import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务

    @RequestMapping(value="/get/{id}")
    @HystrixCommand(fallbackMethod = "getProductFallBack")
    public Object get(@PathVariable("id") long id) {
        Product product = iProductService.get(id) ;
        //模仿异常
        if (null == product){
            throw new RuntimeException("当前商品不存在");
        }
        return product;
    }

    /**
     * 服务降级
     * @param id
     * @return
     */
    public Product getProductFallBack(long id){
        Product product = new Product();
        product.setProductId(id);
        product.setProductName("HystrixName");
        product.setProductDesc("HystrixDesc");
        return product;
    }

    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }


    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }
}