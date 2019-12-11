package com.hss.springcloud.dao;

import com.hss.springcloud.entities.Dept;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeptDao {
    //增加
    public Boolean addDept(Dept dept);
    //由id查找
    public Dept findById(@Param(value = "id") Long id);
    //查询
    public List<Dept> findAll();
    //删
    public Boolean deleteDept(@Param(value = "id")Long id);
    //增加，返回主键
    public Long addDeptKey(Dept dept);
}
