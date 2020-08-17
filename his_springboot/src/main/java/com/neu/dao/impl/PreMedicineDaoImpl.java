package com.neu.dao.impl;

import com.neu.dao.PreMedicineDao;
import com.neu.entity.po.PreMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PreMedicineDaoImpl implements PreMedicineDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<PreMedicine> mapper=new BeanPropertyRowMapper<PreMedicine>(PreMedicine.class);


    @Override
    public List<PreMedicine> queryPreMedicineByPreID(int preID) {
        String sql="select * from premedicine where prescriptionID=? ";
        return jdbcTemplate.query(sql,mapper,preID);
    }
}
