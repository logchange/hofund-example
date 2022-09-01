package dev.logchange.hofund.testapp.stats.products;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("products")
public interface ProductsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> getProducts();

}