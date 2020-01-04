package com.xu.spring.test.dal.mapper;

import com.xu.spring.test.dal.model.UserActivityDO;
import com.xu.spring.test.dal.query.UserActivityQuery;

import java.util.List;

public interface UserActivityDOMapper extends BaseMapper<UserActivityDO> {


    List<UserActivityDO> queryUserActivityList(UserActivityQuery query);

    Long queryUserActivityListCount(UserActivityQuery query);

    void updateBatch(List<UserActivityDO> list);
}