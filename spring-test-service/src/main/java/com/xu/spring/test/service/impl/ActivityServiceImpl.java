package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Page;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.enums.DelEnum;
import com.xu.spring.test.common.util.CopyUtil;
import com.xu.spring.test.dal.mapper.ActivityDOMapper;
import com.xu.spring.test.dal.mapper.UserActivityDOMapper;
import com.xu.spring.test.dal.model.ActivityDO;
import com.xu.spring.test.dal.model.UserActivityDO;
import com.xu.spring.test.dal.query.ActivityQuery;
import com.xu.spring.test.dal.query.UserActivityQuery;
import com.xu.spring.test.service.ActivityService;
import com.xu.spring.test.service.dto.ActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDOMapper activityDOMapper;

    @Autowired
    UserActivityDOMapper userActivityDOMapper;

    @Override
    public Result queryActivityList(ActivityQuery query) {
        List<Long> activityIdList = new ArrayList<>();
        if (query.getUserId() != null) {
            activityIdList = getJoinActivityIdList(query.getUserId());
        }
        Result result = new Result();
        if (!CollectionUtils.isEmpty(activityIdList)) {
            query.setIdList(activityIdList);
            query.setDel(DelEnum.NOT_DEL.getCode());
            Long count = activityDOMapper.queryActivityListCount(query);
            if (count > 0) {
                List<ActivityDO> list = activityDOMapper.queryActivityList(query);
                List<ActivityDTO> dtoList = CopyUtil.copyPropertiesList(list, ActivityDTO.class);
                Page page = new Page(query.getCurrentPage(), count, dtoList);
                result.setContent(page);
            }
        }
        return result;
    }

    private List<Long> getJoinActivityIdList(Long userId) {
        UserActivityQuery query = new UserActivityQuery();
        query.setPageSize(Long.MAX_VALUE);
        query.setCancel(DelEnum.NOT_DEL.getCode());
        query.setUserId(userId);
        List<UserActivityDO> list = userActivityDOMapper.queryUserActivityList(query);
        return list.stream().map(UserActivityDO::getActivityId).distinct().collect(Collectors.toList());
    }
}
