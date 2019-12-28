package com.hss.springcloud;

import com.hss.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 消费者
 * 开启识别消费者@EnableDiscoveryClient
 * @RibbonClients标签用法：
 * @RibbonClients(value = {
 *         @RibbonClient(name = "ribbon-client",configuration = MyConfiguration.class),
 *         @RibbonClient(name = "ribbon-client-b",configuration = MyConfiguration.class)
 * })
 */
@EnableDiscoveryClient
@SpringBootApplication
//在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration =MySelfRule.class )
public class DeptConsumer80App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80App.class, args);
    }

}
