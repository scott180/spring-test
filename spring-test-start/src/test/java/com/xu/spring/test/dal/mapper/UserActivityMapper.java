package com.xu.spring.test.dal.mapper;

import com.xu.spring.test.dal.model.UserActivity;

public interface UserActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserActivity record);

    int insertSelective(UserActivity record);

    UserActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserActivity record);

    int updateByPrimaryKey(UserActivity record);
}