package com.hss.springcloud.rest;

import com.hss.springcloud.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ConfigClientRest {

    @Autowired
    private MyConfig myConfig;

    @RequestMapping(value = "/config")
    public Map<String,Object> getConfig(){
        Map<String,Object> resultMap = new LinkedHashMap<String, Object>();

        String str = "applicationName:" + myConfig.getApplicationName() +
                "\t eurekaServers:" + myConfig.getEurekaServers() +
                "\t port" + myConfig.getPort() +
                "\t myName:" + myConfig.getMyName();
        System.out.println("------------>str:"+str);

        resultMap.put("applicationName",myConfig.getApplicationName());
        resultMap.put("eurekaServers",myConfig.getEurekaServers());
        resultMap.put("port",myConfig.getPort());
        resultMap.put("myName",myConfig.getMyName());
        return resultMap;
    }
}
