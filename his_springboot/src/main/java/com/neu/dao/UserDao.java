package com.neu.dao;

import com.neu.entity.po.User;

import java.util.List;

public interface UserDao  {
    //查询用户是否存在
    public User queryUserByNameAndPassword(String username, String password);

    //根据部门查找医生
    public List<User> queryUsersByDepartment(int departmentID);

    //根据ID查找用户（医生）
    public User queryUserByID(int id);
}
