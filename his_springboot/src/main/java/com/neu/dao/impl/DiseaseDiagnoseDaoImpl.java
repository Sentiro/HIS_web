package com.neu.dao.impl;

import com.neu.dao.DiseaseDiagnoseDao;
import com.neu.entity.po.DiseaseDiagnose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public class DiseaseDiagnoseDaoImpl implements DiseaseDiagnoseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<DiseaseDiagnose> mapper=new BeanPropertyRowMapper<>(DiseaseDiagnose.class);

    @Override
    public String insertDiseasesDiagnose() {
        return null;
    }

    @Override
    public int insertOneDiseaseDiagnose(DiseaseDiagnose diseaseDiagnose) {
        diseaseDiagnose.setDatetime(String.valueOf(LocalDateTime.now()));
        String sql="insert into diseasediagnose(ICD,diagnoseID,time,regID) values(?,?,?,?)";
        return jdbcTemplate.update(sql,diseaseDiagnose.getDiseaseID(),diseaseDiagnose.getDiagnoseID(),diseaseDiagnose.getDatetime(),diseaseDiagnose.getRegID());
    }
}
