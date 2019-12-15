package com.hss.springcloud.dao;

import com.hss.springcloud.entities.Dept;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptDaoTest {

    private final static Logger logger = Logger.getLogger(DeptDaoTest.class);

    @Autowired
    private DeptDao deptDao;

    @Test
    public void addDept() {
        Dept dept = new Dept();
        dept.setDeptName("五六七");
        Boolean flag = deptDao.addDept(dept);
        logger.info("flag>>>>>="+flag);
    }

    @Test
    public void findById() {
        Dept dept = deptDao.findById(1L);
        logger.info("dept="+dept);
    }

    @Test
    public void findAll() {
        List<Dept> depts = deptDao.findAll();
        logger.info("depts="+depts);
    }

    @Test
    public void deleteDept() {
        Boolean flag = deptDao.deleteDept(1L);
        logger.info("flag>>>>>="+flag);
    }

    @Test
    public void addDeptKey(){
        Dept dept = new Dept();
        dept.setDeptName("五六七...");
        deptDao.addDeptKey(dept);
        logger.info("id="+dept.getDeptNo());
    }
}