package com.neu.dao.impl;

import com.neu.dao.RegisterInfoDao;
import com.neu.entity.po.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public class RegisterInfoDaoImpl implements RegisterInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<RegisterInfo> mapper=new BeanPropertyRowMapper<RegisterInfo>(RegisterInfo.class);

    @Override
    public List<RegisterInfo> queryRegisterInfoByDoc(int docID, String date) {
        String sql="select * from registerInfo where doctorID=? and regDate=?";
        return jdbcTemplate.query(sql,mapper,docID,date);
    }

    @Override
    public List<RegisterInfo> queryRegisterInfoByBingliID(int bingliID) {
        String sql="select * from registerInfo where medRecordID=?";
        return jdbcTemplate.query(sql,mapper,bingliID);
    }

    @Override
    public RegisterInfo queryRegisterInfoByRegID(int regID) {
        String sql="select * from registerInfo where registerID=?";

        return jdbcTemplate.queryForObject(sql,mapper,regID);
    }

    @Override
    public int updateStatus(int regID, String status) {
        String str="update registerInfo set regStatus=? where registerID=? ";

        int i =jdbcTemplate.update(str,new Object[]{status,regID});
        return i;
    }
}
