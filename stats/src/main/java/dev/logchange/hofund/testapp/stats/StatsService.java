package dev.logchange.hofund.testapp.stats;

import dev.logchange.hofund.testapp.stats.products.Product;
import dev.logchange.hofund.testapp.stats.products.ProductsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StatsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ProductsClient productsClient;

    public StatsService(ProductsClient productsClient) {
        this.productsClient = productsClient;
    }

    public List<Stat> getStats(){
        List<Product> products = productsClient.getProducts();

        log.info("Got stats about products");

        List<Stat> stats = new LinkedList<>();
        for (Product product: products) {
            stats.add(new Stat(product.getId(), product.getName()));
        }

        return stats;
    }
}
