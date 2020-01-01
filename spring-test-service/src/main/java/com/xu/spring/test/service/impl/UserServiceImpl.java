package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Page;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.mapper.UserDOMapper;
import com.xu.spring.test.dal.model.UserDO;
import com.xu.spring.test.dal.query.UserQuery;
import com.xu.spring.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Result queryUserList(UserQuery query) {
        Long count = userDOMapper.queryUserListCount(query);
        Result result = new Result();
        if (count > 0) {
            List<UserDO> list = userDOMapper.queryUserList(query);
            Page page = new Page(query.getCurrentPage(), count, list);
            result.setContent(page);
        }
        return result;
    }
}
