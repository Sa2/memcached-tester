package com.memcachedtesterclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Sa2 on 2017/01/09.
 */
@Component
@ConfigurationProperties(prefix="app.env.memcached.basic")
@Data
public class BasicMemcachedConfig {

    private String host;
    private int port;
    private int expr;

    public void displayHost() {
        System.out.println(host);
    }
}
