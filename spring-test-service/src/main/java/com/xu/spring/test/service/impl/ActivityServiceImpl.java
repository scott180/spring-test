package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Page;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.util.CopyUtil;
import com.xu.spring.test.dal.mapper.ActivityDOMapper;
import com.xu.spring.test.dal.model.ActivityDO;
import com.xu.spring.test.dal.query.ActivityQuery;
import com.xu.spring.test.service.ActivityService;
import com.xu.spring.test.service.dto.ActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDOMapper activityDOMapper;

    @Override
    public Result queryActivityList(ActivityQuery query) {
        List<Long> activityIdList = new ArrayList<>();
        if (query.getUserId() != null) {
            activityIdList = getJoinActivityIdList(query.getUserId());
        }
        query.setIdList(activityIdList);
        Long count = activityDOMapper.queryActivityListCount(query);
        Result result = new Result();
        if (count > 0) {
            List<ActivityDO> list = activityDOMapper.queryActivityList(query);
            List<ActivityDTO> dtoList = CopyUtil.copyPropertiesList(list, ActivityDTO.class);
            Page page = new Page(query.getCurrentPage(), count, dtoList);
            result.setContent(page);
        }
        return result;
    }

    private List<Long> getJoinActivityIdList(Long userId) {

        return null;
    }
}
