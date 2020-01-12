package com.hss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient_3355_StartSpringCloudApp {

    public static void main(String[] args){
        SpringApplication.run(ConfigClient_3355_StartSpringCloudApp.class,args);
    }
}
