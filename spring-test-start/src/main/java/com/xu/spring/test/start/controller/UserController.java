package com.xu.spring.test.start.controller;

import com.xu.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    /*@Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("queryLoginName")
    public String queryLoginName(Long id) {
        return userService.queryLoginName(id);
    }*/

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
