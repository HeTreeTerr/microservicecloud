package com.hss.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.hss.springcloud.dao") //扫描的mapper
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
public class DeptProvider8002App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002App.class, args);
    }

}
