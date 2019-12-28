package com.hss.springcloud.controller;

import com.hss.springcloud.entities.Dept;
import com.hss.springcloud.service.DeptClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController_Consumer {

    private final static Logger logger = Logger.getLogger(DeptController_Consumer.class);

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }

    @RequestMapping(value = "/dept/delete/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable(value = "id") Long id){
        return this.service.delete(id);
    }
}
