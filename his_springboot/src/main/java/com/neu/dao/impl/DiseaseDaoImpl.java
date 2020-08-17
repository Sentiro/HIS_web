package com.neu.dao.impl;

import com.neu.dao.DiseaseDao;
import com.neu.entity.po.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class DiseaseDaoImpl implements DiseaseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Disease> mapper=new BeanPropertyRowMapper<>(Disease.class);

    //TODO 远程搜索疾病
    @Override
    public List<Disease> queryLikeDisease(String str) {
        String sql="select * from disease where pinyin like?";
        return jdbcTemplate.query(sql,mapper,"%"+str+"%");
    }
}
