package com.neu.dao.impl;

import com.neu.dao.PatientDao;
import com.neu.entity.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Patient> mapper=new BeanPropertyRowMapper<Patient>(Patient.class);

    @Override
    public List<Patient> queryPatientByBingliID(int id) {
        String sql="select* from patient where medRecordID=?";
        return jdbcTemplate.query(sql,mapper,id);
    }

    @Override
    public int queryAvailableBingliID() {
        String sql="select max(medRecordID) from patient";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
