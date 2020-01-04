package com.xu.spring.test.start.controller;

import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.params.ActivityPublishParams;
import com.xu.spring.test.dal.query.ActivityQuery;
import com.xu.spring.test.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xu
 * @date 2020/1/1 18:48
 */
@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ResponseBody
    @RequestMapping(value = "queryActivityList", method = RequestMethod.POST)
    public Result queryActivityList(ActivityQuery query) {
        return activityService.queryActivityList(query);
    }

    @ResponseBody
    @RequestMapping(value = "queryActivityDetail", method = RequestMethod.GET)
    public Result queryActivityDetail(Long id) {
        return activityService.queryActivityDetail(id);
    }

    @ResponseBody
    @RequestMapping(value = "publishActivity", method = RequestMethod.POST)
    public Result publishActivity(ActivityPublishParams params) {
        return activityService.publishActivity(params);
    }
}
