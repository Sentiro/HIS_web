package com.neu.service;

import com.neu.dao.UserDao;
import com.neu.dao.impl.UserDaoImpl;
import com.neu.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
    * @Description: 根据账号密码查询某个user
    * @Param:  String id， String password
    * @return:  User
    * @Author: Sentiro
    * @Date: 2020/7/16
    */
    public User login(String id,String password){
        return userDao.queryUserByNameAndPassword(id,password);
    }

    public List<User> getDoctorByDepartment(int departID){
       return userDao.queryUsersByDepartment(departID);
    }
}
