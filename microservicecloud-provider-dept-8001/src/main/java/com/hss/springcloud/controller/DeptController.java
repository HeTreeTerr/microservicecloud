package com.hss.springcloud.controller;

import com.hss.springcloud.entities.Dept;
import com.hss.springcloud.service.DeptService;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Boolean add(@RequestBody Dept dept){
        logger.info("执行添加部门信息");
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        logger.info("由id查找部门信息");
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        logger.info("查找所有部门信息");
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/delete/{id}",method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Long id){
        logger.info("查找所有部门信息");
        return deptService.deleteDept(id);
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        logger.info("********"+list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element : srvList){
            logger.info(element.getServiceId()+ "\t" +element.getHost()+ "\t"
                + element.getPort() +"\t"+element.getUri());
        }
        return this.discoveryClient;
    }
}
