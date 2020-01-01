package com.xu.spring.test.dal.mapper;

import com.xu.spring.test.dal.model.ActivityDO;
import com.xu.spring.test.dal.query.ActivityQuery;

import java.util.List;

public interface ActivityDOMapper extends BaseMapper<ActivityDO> {
    List<ActivityDO> queryActivityList(ActivityQuery query);

    Long queryActivityListCount(ActivityQuery query);
}