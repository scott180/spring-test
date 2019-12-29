package com.xu.spring.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xu.spring.test.dal.mapper.UserMapper;
import com.xu.spring.test.dal.model.User;
import com.xu.spring.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public String queryLoginName(Long id) {
        return "test";
    }

    public User selectById(Long id) {
       return userMapper.selectById(id);
    }
}
