package dev.logchange.hofund.testapp.stats.products;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class ProductsClient {

    private final RestClient restClient;

    public ProductsClient(@Value("${client.products.url:http://host.docker.internal:18081/}") String productsUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(productsUrl)
                .build();
    }

    public List<Product> getProducts() {
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {});
    }
}
