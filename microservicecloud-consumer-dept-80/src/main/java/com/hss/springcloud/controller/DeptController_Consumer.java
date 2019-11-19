package com.hss.springcloud.controller;

import com.hss.springcloud.entities.Dept;
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

    private static final String RESR_URL_PREFIX = "http://localhost:8001";

    /*
    使用restTemplate访问restful接口非常的简单粗暴无脑。
    （url,requestMap,ResponseBean.class）这三个参数分别代表：
    rest请求地址、请求参数、HTTP响应转换被转换成的对象类型
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(RESR_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(RESR_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(RESR_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping(value = "/consumer/dept/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
//        Map<String, Object> classifyMap = new HashMap<>();
//        classifyMap.put("id",id);
        restTemplate.delete(RESR_URL_PREFIX+"/dept/delete/"+id);
    }
}
