package com.neu.dao.impl;

import com.neu.entity.po.Prescription;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProceduresImplTest {

    @Autowired
    ProceduresImpl procedures;

    @Test
    void pay() {
        String str= procedures.pay(75,1234);
        System.out.println(str);
    }

    @Test

    void register() {
    }

    @Test
    void refund() {
    }

    @Test
    void diagnose() {
    }

    @Test
    void prescript() {
        Prescription prescription=new Prescription();
        prescription.setRegisterID(39);
        prescription.setPrescriptionID(81);
        prescription.setPreName("ceshi");
        System.out.println(procedures.prescript(prescription,"[{\"id\":1482,\"num\":2,\"times\":\"1\",\"usage\":\"1\"}]"));
    }

    @Test
    void distributeMed() {
    }

    @Test
    void refundReg() {
        System.out.println(procedures.refundReg(29));
    }
}