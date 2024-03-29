package com.hss.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.hss.springcloud.dao") //扫描的mapper
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class DeptProvider8001_Config_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Config_App.class, args);
    }

}
