package com.neu.dao.impl;

import com.neu.dao.DepartmentDao;
import com.neu.entity.po.Bill;
import com.neu.entity.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Department> mapper=new BeanPropertyRowMapper<Department>(Department.class);


    @Override
    public List<Department> getDeparts() {

        return jdbcTemplate.query("select * from deparment",mapper);
    }
}
