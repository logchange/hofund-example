package dev.logchange.hofund.testapp.stats.health;

import dev.logchange.hofund.connection.AbstractHofundBasicHttpConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueHealthCheck extends AbstractHofundBasicHttpConnection {


    @Value("${hofund.connection.queue.target:queue}")
    private String target;

    @Value("${hofund.connection.queue.url:https://google.com/}")
    private String basicUrl;

    @Override
    protected String getTarget() {
        return target;
    }

    @Override
    protected String getUrl() {
        return basicUrl;
    }

}
