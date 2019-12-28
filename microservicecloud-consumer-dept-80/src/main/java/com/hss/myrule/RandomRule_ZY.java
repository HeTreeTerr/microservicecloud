package com.hss.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class RandomRule_ZY extends AbstractLoadBalancerRule {

    /*
    total = 0 // 当total==5以后，我们指针才能往下走，
    index = 0 // 当前对提供服务的服务器地址
    total需要重新置为0，但是已经到达过一个5次，我们的index = 1
    分析：我们5次，但是微服务只有8001 8002 8003 三台，ok
     */

    private int total = 0; //总共被调用的次数，目前要求每台被调用5次

    private int currentIndex = 0; //当前提供服务的机器号

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(),o);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if(lb == null){
            return null;
        }
        Server server = null;

        while (server == null){
            if(Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if(serverCount == 0){
                return null;
            }

            if(total < 5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            if(server.isAlive()){
                return (server);
            }

            server = null;
            Thread.yield();
        }
        return server;
    }

}
