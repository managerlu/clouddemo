package cn.enjoy.service;

import cn.enjoy.config.FeignClientConfig;
import cn.enjoy.service.impl.ProductServiceFactory;
import cn.enjoy.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class,fallbackFactory = ProductServiceFactory.class)
public interface IProductClientService {

    @RequestMapping("/prodcut/get/{id}")
    Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/prodcut/list")
    List<Product> listProduct() ;

    @RequestMapping("/prodcut/add")
    boolean addPorduct(Product product) ;
}
