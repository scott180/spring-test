package com.xu.spring.test.service;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.query.ActivityQuery;

public interface ActivityService {

    Result queryActivityList(ActivityQuery query);

}