package com.neu.dao.impl;

import com.neu.dao.PrescriptionDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrescriptionDaoImplTest {

    @Autowired
    PrescriptionDao prescriptionDao;
    @Test
    void queryByRegID() {
        System.out.println(prescriptionDao.queryByRegID(35));
    }
}