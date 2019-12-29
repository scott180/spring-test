package com.xu.spring.test.service.impl;

import com.xu.spring.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public String queryLoginName(Long id){
        return "test";
    }
}
