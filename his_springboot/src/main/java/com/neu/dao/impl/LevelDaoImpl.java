package com.neu.dao.impl;

import com.neu.dao.LevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LevelDaoImpl implements LevelDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Float queryLevelPriceByID(int id) {
        String sql="select price from level where ID=?";
        return jdbcTemplate.queryForObject(sql,Float.class,id);
    }
}
