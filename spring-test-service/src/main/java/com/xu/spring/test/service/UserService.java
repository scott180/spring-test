package com.xu.spring.test.service;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.query.UserQuery;
import com.xu.spring.test.dal.model.UserDO;

public interface UserService {
    String queryLoginName(Long id);

    Result selectById(Long id);

    Result queryList(UserQuery query);

}
