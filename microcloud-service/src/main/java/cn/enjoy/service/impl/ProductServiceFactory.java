package cn.enjoy.service.impl;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务熔断
 */
@Component
public class ProductServiceFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(id);
                product.setProductDesc("HystrixDescServer");
                product.setProductName("HystrixNameServer");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }
        };
    }
}
