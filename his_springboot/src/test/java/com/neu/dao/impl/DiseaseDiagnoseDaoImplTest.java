package com.neu.dao.impl;

import com.neu.dao.DiseaseDiagnoseDao;
import com.neu.entity.po.DiseaseDiagnose;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class DiseaseDiagnoseDaoImplTest {

    @Autowired
    DiseaseDiagnoseDao diseaseDiagnoseDao;

    //TODO 插入疾病诊断表有问题
    @Test
    void insertOneDiseaseDiagnose() {
        DiseaseDiagnose d=new DiseaseDiagnose();
        d.setDiseaseID(1);
        d.setRegID(40);
        d.setDiagnoseID(37);
        d.setDatetime(String.valueOf(LocalDateTime.now()));
        System.out.println(diseaseDiagnoseDao.insertOneDiseaseDiagnose(d));
    }
}