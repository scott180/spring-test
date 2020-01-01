package com.xu.spring.test.service;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.query.UserActivityQuery;

/**
 * @author xu
 * @date 2020/1/1 22:16
 */
public interface UserActivityService {
    Result queryUserActivityList(UserActivityQuery query);
}
