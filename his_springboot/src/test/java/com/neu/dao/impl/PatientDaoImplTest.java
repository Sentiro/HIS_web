package com.neu.dao.impl;

import com.neu.dao.PatientDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientDaoImplTest {

    @Autowired
    PatientDao patientDao;
    @Test
    void queryPatientByBingliID() {
        System.out.println(patientDao.queryPatientByBingliID(600705));
    }
}