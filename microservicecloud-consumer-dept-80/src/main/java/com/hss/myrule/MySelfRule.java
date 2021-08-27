package com.hss.myrule;

import com.netflix.loadbalancer.*;
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
//        随机策略
//        return new RandomRule();

//        轮询策略(默认)
//        return new RoundRobinRule();

//        可用过滤策略(会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数超过阈值的服务，然后对剩余的服务列表进行轮询)
//        return new AvailabilityFilteringRule();

//        响应时间加权重策略
//        return new WeightedResponseTimeRule();

//        重试策略
//        return new RetryRule();

//        最低并发策略
//        return new BestAvailableRule();

//        区域权重策略
//        return new ZoneAvoidanceRule();

//        自定义每台机器5次
        return new RandomRule_ZY();
    }
}
