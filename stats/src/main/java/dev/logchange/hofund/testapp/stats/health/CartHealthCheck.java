package dev.logchange.hofund.testapp.stats.health;

import dev.logchange.hofund.connection.AbstractHofundBasicHttpConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartHealthCheck extends AbstractHofundBasicHttpConnection {


    @Value("${hofund.connection.cart.target:cart}")
    private String target;

    @Value("${hofund.connection.cart.url:http://host.docker.internal:18082/}")
    private String basicUrl;

    @Value("${hofund.connection.cart.url.suffix:actuator/health}")
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
