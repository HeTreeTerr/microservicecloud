package com.hss.springcloud.service;

import com.hss.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    //增加
    public Boolean addDept(Dept dept);
    //由id查找
    public Dept findById(Long id);
    //查询
    public List<Dept> findAll();
    //删
    public Boolean deleteDept(Long id);
}
