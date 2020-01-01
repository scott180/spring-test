package com.xu.spring.test.dal.mapper;

import com.xu.spring.test.dal.model.UserDO;
import com.xu.spring.test.dal.query.UserQuery;

import java.util.List;

public interface UserDOMapper extends BaseMapper<UserDO> {

    List<UserDO> queryUserList(UserQuery query);

    Long queryUserListCount(UserQuery query);
}