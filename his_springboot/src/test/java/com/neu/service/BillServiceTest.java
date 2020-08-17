package com.neu.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BillServiceTest {

    @Autowired
    BillService billService;

    @Test
    void getPayBills() {

        System.out.println( billService.getBills(600704,"已开立"));
    }

    @Test
    void payOnePre() {
        System.out.println(billService.payOnePre(76,1234));
    }
}