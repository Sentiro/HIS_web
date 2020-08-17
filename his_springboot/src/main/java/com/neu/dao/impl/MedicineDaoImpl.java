package com.neu.dao.impl;

import com.neu.dao.MedicineDao;
import com.neu.entity.po.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineDaoImpl implements MedicineDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Medicine> mapper=new BeanPropertyRowMapper<>(Medicine.class);
    //TODO 远程搜索药品
    @Override
    public List<Medicine> queryLikeMedicine(String str) {

        String sql="select * from medicine where pinyin like?";
        return jdbcTemplate.query(sql,mapper,"%"+str+"%");
    }

    @Override
    public Medicine queryOneByID(int id) {
        String sql="select * from medicine where ID=?";
        return jdbcTemplate.queryForObject(sql,mapper,id);
    }
}
