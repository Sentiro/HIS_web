package com.neu.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class RegisterInfoServiceTest {

    @Autowired
    RegisterInfoService registerInfoService;

    @Test
    void insert() {
    }

    @Test
    void refund() {
    }

    @Test
    void getPatientOfDoc() {
        System.out.println(registerInfoService.getPatientOfDoc(1,"2020-7-10"));
    }

    @Test
    void getLevelPrice() {
    }

    @Test
    void getRegisterInfoByBingliID() {
    }
}