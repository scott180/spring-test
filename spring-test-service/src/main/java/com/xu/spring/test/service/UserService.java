package com.xu.spring.test.service;

import com.xu.spring.test.dal.model.User;

public interface UserService {
    String queryLoginName(Long id);

    User selectById(Long id);
}
