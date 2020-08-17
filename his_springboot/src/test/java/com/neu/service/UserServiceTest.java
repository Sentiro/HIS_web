package com.neu.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void login() {
        UserService userService=new UserService();
        System.out.println(userService.login("bianque","0"));
    }

    @Test
    void getDoctorByDepartment() {
    }
}