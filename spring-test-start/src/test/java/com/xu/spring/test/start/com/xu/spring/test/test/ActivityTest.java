package com.xu.spring.test.start.com.xu.spring.test.test;

/**
 * @author xu
 * @date 2020/1/4 17:15
 */

import com.alibaba.fastjson.JSON;
import com.xu.spring.test.Application;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.dal.query.ActivityQuery;
import com.xu.spring.test.start.controller.ActivityController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

//import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActivityTest {
    private Logger logger = Logger.getLogger(ActivityTest.class.getName());
    @Autowired
    private ActivityController activityController;

    @Test
    public void testQueryActivityList() {
        ActivityQuery query = new ActivityQuery();
        query.setBeginTime("2020-01-04 10:00:00");
        query.setName("周日");
        Result result = activityController.queryActivityList(query);
        logger.info("result: " + JSON.toJSONString(result));
    }

    @Test
    public void testQueryActivityDetail() {
        Result result = activityController.queryActivityDetail(1L);
        logger.info("result: " + JSON.toJSONString(result));
    }
}
