package dev.logchange.hofund.testapp.stats.health;

import dev.logchange.hofund.connection.AbstractHofundBasicHttpConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductsHealthCheck extends AbstractHofundBasicHttpConnection {


    @Value("${hofund.connection.products.target:products}")
    private String target;

    @Value("${hofund.connection.products.url:http://host.docker.internal:18081/}")
    private String basicUrl;

    @Value("${hofund.connection.products.url.suffix:actuator/health}")
    private String urlSuffix;

    @Override
    protected String getTarget() {
        return target;
    }

    @Override
    protected String getUrl() {
        return basicUrl + urlSuffix;
    }

}
