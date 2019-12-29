package com.xu.spring.test.start.controller;

import com.xu.spring.test.dal.model.User;
import com.xu.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("selectById")
    public User selectById(Long id) {
        return userService.selectById(id);
    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
