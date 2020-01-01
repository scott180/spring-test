package com.xu.spring.test.start.controller;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.query.UserQuery;
import com.xu.spring.test.dal.model.UserDO;
import com.xu.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("selectById")
    public Result selectById(Long id) {
        return userService.selectById(id);
    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "queryList",method = RequestMethod.POST)
    public Result queryList(UserQuery query) {
        return userService.queryList(query);
    }
}
