package com.hss.springcloud.service;

import com.hss.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 千万不要忘记在类上面新增@Component注解，大坑！！！
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptNo(id).setDeptName("没有对应的信息，" +
                        "Consumer客户端提供的降级服务，此刻服务Provider已经关闭")
                        .setDbSource("no this database in Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Boolean add(Dept dept) {
                return null;
            }

            @Override
            public Boolean delete(Long id) {
                return null;
            }
        };
    }
}
