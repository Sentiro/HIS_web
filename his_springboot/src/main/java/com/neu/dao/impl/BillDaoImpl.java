package com.neu.dao.impl;

import com.neu.dao.BillDao;
import com.neu.entity.po.Bill;
import com.neu.entity.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillDaoImpl implements BillDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Bill> mapper=new BeanPropertyRowMapper<Bill>(Bill.class);

    @Override
    public List<Bill> queryBillsByRegID(int regID) {
        String sql= "select * from bill where regID=? ";
        return jdbcTemplate.query(sql,mapper,regID);
    }
}
