package com.hss.springcloud.controller;

import com.hss.springcloud.entities.Dept;
import com.hss.springcloud.service.DeptService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    private final static Logger logger = Logger.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        logger.info("由id查找部门信息");
        Dept dept = deptService.findById(id);
        if(dept == null){
            throw new RuntimeException("不存在该用户");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){

        return new Dept().setDeptNo(id).setDeptName("没有对应的信息，null--@HystrixCommand")
                .setDbSource("no this database in Mysql");
    }
}
