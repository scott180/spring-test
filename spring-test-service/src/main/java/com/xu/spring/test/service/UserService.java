package com.xu.spring.test.service;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.query.UserQuery;

public interface UserService {
    String queryLoginName(Long id);

    Result selectById(Long id);

    Result queryUserList(UserQuery query);

}
