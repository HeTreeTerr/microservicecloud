package com.hss.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户自己书写的Ribbon负载均衡配置规则不能和
 * springCloud的主启动类（@ComponentScan所扫描）的当前包下以及子包下。
 * 否则我们的自定义的这个配置类会被所有的Ribbon客户端所共享。也就是
 * 说我们达不到特殊化定制的目的了。
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
//        随机
//        return new RandomRule();
//        默认轮询
//        return new RoundRobinRule();
//        自定义每台机器5次
        return new RandomRule_ZY();
    }
}
