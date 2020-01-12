package com.hss.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ConfigClientRest {

    @Value(value = "${spring.application.name}")
    private String applicationName;

    @Value(value = "${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value(value = "${server.port}")
    private String port;

    @RequestMapping(value = "/config")
    public Map<String,Object> getConfig(){
        Map<String,Object> resultMap = new LinkedHashMap<String, Object>();

        String str = "applicationName:" + applicationName +
                "\t eurekaServers:" + eurekaServers +
                "\t port" + port;
        System.out.println("------------>str:"+str);

        resultMap.put("applicationName",applicationName);
        resultMap.put("eurekaServers",eurekaServers);
        resultMap.put("port",port);
        return resultMap;
    }
}
