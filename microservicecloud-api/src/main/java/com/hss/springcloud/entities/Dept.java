package com.hss.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门实体类
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    /* 主键*/
    private Long deptNo;
    /* 部门名称*/
    private String deptName;
    /* 来自哪个数据库，因为微服务架构可以一个服务对用一个数据库，同一个信息被存储在不同数据库*/
    private String dbSource;

}
