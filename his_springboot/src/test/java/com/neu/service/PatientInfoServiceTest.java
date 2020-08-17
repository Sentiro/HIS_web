package com.neu.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientInfoServiceTest {

    @Autowired
    PatientInfoService patientInfoService;
    @Test
    void getPatientByBingliID() {
        System.out.println(patientInfoService.getPatientByBingliID(600705));
    }
}