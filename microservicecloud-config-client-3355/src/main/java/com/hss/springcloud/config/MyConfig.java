package com.hss.springcloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@RefreshScope
public class MyConfig {

    @Value(value = "${spring.application.name}")
    private String applicationName;

    @Value(value = "${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value(value = "${server.port}")
    private String port;

    @Value(value = "${my-name}")
    private String myName;
}
