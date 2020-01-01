package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.query.UserQuery;
import com.xu.spring.test.dal.mapper.UserDOMapper;
import com.xu.spring.test.dal.model.UserDO;
import com.xu.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDOMapper userDOMapper;

    public String queryLoginName(Long id) {
        return "test";
    }

    public Result selectById(Long id) {
       return Result.success(userDOMapper.selectByPrimaryKey(id));
    }

    public Result queryList(UserQuery query){
        return null;
    }
}
