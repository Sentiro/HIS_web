package com.neu.controller;

import com.neu.entity.po.User;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class LoginController {
    @Autowired
    UserService userService;


    /**
    * @Description: 处理登录功能
    * @Param:  String id，String password
    * @return:  User ，如果不存在返回null
    * @Author: Sentiro
    * @Date: 2020/7/22
    */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User say(@RequestParam(value="id",required = true,defaultValue = "0") String id,
                    @RequestParam(value="password",required = true,defaultValue = "0") String password
                      ) {
      //  productRepo.put(product.getID(), product);
                return userService.login(id,password);
              //  return "[controller]"+id+" "+password;
         }

//      @RequestMapping(value = "/login")
//    public String say(){
//        System.out.println("[get]");
//        return "login controller get";
//      }

}
