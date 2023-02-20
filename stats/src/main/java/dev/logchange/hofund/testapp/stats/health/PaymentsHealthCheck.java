package dev.logchange.hofund.testapp.stats.health;

import dev.logchange.hofund.connection.AbstractHofundBasicHttpConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentsHealthCheck extends AbstractHofundBasicHttpConnection {


    @Value("${hofund.connection.payment.target:payment}")
    private String target;

    @Value("${hofund.connection.payment.url:http://host.docker.internal:18083/}")
    private String basicUrl;

    @Value("${hofund.connection.payment.url.suffix:actuator/health}")
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
