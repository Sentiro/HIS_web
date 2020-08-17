package com.neu.dao.impl;


import com.neu.dao.UserDao;
import com.neu.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<User> mapper=new BeanPropertyRowMapper<User>(User.class);

    @Override
    public User queryUserByNameAndPassword(String username, String password) {
        String sql="select * from users where uName=? and uPassword=?";
        User user=jdbcTemplate.queryForObject(sql,mapper,username,password);
        return user;
    }

    @Override
    public List<User> queryUsersByDepartment(int departmentID) {
        String sql="select * from users where departmentID=? and uType=3";
        List<User> users=jdbcTemplate.query(sql,mapper,departmentID);
        return users;
    }

    @Override
    public User queryUserByID(int id) {
        String sql="select * from users where uID=?";
        User user=jdbcTemplate.queryForObject(sql,mapper,id);
        return user;
    }
}
