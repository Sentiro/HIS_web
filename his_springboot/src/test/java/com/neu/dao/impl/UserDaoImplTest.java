package com.neu.dao.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoImplTest {
    @Autowired
    UserDaoImpl userDao;

    @Test
    void queryUserByNameAndPassword() {
        System.out.println(userDao.queryUserByNameAndPassword("bianque","0"));
    }

    @Test
    void queryUsersByDepartment() {
        System.out.println(userDao.queryUsersByDepartment(1));
    }
}