package cn.enjoy.controller;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
//    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/prodcut/get/";
//    public static final String PRODUCT_LIST_URL="http://localhost:8080/prodcut/list/";
//    public static final String PRODUCT_ADD_URL = "http://localhost:8080/prodcut/add/";
//    @Resource
//    private RestTemplate restTemplate;
//
//    @Resource
//    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private IProductClientService productClientService;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
//        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
//        return  product;
        //通过这个对象获取服务提供者的信息
//        ServiceInstance serviceInstance = loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
//        System.out.println(
//                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
//                        + "、port = " + serviceInstance.getPort()
//                        + "、serviceId = " + serviceInstance.getServiceId());
//        Product product = restTemplate.exchange(PRODUCT_GET_URL + id,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
//        return product;
        return productClientService.getProduct(id);
    }

//    @RequestMapping("/product/list")
//    public  Object listProduct() {
//        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,
//                new HttpEntity<Object>(httpHeaders), List.class).getBody();
//        return  list;
//    }
//
//    @RequestMapping("/product/add")
//    public Object addPorduct(Product product) {
//        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,
//                new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
//        return  result;
//    }
}