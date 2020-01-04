package com.xu.spring.test.service;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.params.ActivityPublishParams;
import com.xu.spring.test.dal.query.ActivityQuery;

public interface ActivityService {

    Result queryActivityList(ActivityQuery query);

    Result queryActivityDetail(Long id);

    Result publishActivity(ActivityPublishParams params);
}
