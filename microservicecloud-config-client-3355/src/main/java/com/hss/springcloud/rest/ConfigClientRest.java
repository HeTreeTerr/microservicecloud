package com.hss.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigClientRest {

    @Value(value = "${spring.application.name}")
    private String applicationName;

    @Value(value = "${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value(value = "${server.port}")
    private String port;

    @Value(value = "${my-name}")
    private String myName;

    @RequestMapping(value = "/config")
    public Map<String,Object> getConfig(){
        Map<String,Object> resultMap = new LinkedHashMap<String, Object>();

        String str = "applicationName:" + applicationName +
                "\t eurekaServers:" + eurekaServers +
                "\t port" + port +
                "\t myName:" + myName;
        System.out.println("------------>str:"+str);

        resultMap.put("applicationName",applicationName);
        resultMap.put("eurekaServers",eurekaServers);
        resultMap.put("port",port);
        resultMap.put("myName",myName);
        return resultMap;
    }
}
