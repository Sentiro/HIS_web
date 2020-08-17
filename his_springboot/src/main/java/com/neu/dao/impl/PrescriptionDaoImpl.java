package com.neu.dao.impl;

import com.neu.dao.PrescriptionDao;
import com.neu.entity.po.PreMedicine;
import com.neu.entity.po.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Prescription> mapper=new BeanPropertyRowMapper<>(Prescription.class);


    @Override
    public List<Prescription> queryByRegID(int regID) {
        String sql="select * from prescription where registerID=?";
        return jdbcTemplate.query(sql,mapper,regID);
    }
}
