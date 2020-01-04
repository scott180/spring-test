package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Page;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.enums.DelEnum;
import com.xu.spring.test.common.enums.ResultEnum;
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
import org.springframework.web.util.HtmlUtils;

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
        Result result = new Result();
        query.setIdList(getJoinActivityIdList(query.getUserId()));
        query.setDel(DelEnum.NOT_DEL.getCode());
        Long count = activityDOMapper.queryActivityListCount(query);
        if (count > 0) {
            List<ActivityDO> list = activityDOMapper.queryActivityList(query);
            List<ActivityDTO> dtoList = CopyUtil.copyPropertiesList(list, ActivityDTO.class);
            Page page = new Page(query.getCurrentPage(), count, dtoList);
            result.setContent(page);
        }
        return result;
    }

    private List<Long> getJoinActivityIdList(Long userId) {
        if (userId == null) {
            return null;
        }
        UserActivityQuery query = new UserActivityQuery();
        query.setPageSize(Long.MAX_VALUE);
        query.setCancel(DelEnum.NOT_DEL.getCode());
        query.setUserId(userId);
        List<UserActivityDO> list = userActivityDOMapper.queryUserActivityList(query);
        return list.stream().map(UserActivityDO::getActivityId).distinct().collect(Collectors.toList());
    }

    @Override
    public Result queryActivityDetail(Long id) {
        if (id == null) {
            return Result.error(ResultEnum.ID_IS_NULL);
        }
        Result result = new Result();
        ActivityDO activityDO = activityDOMapper.selectByPrimaryKey(id);
        if (activityDO == null) {
            return Result.error(ResultEnum.RECORD_NOT_EXIST);
        }
        activityDO.setContent(HtmlUtils.htmlUnescape(activityDO.getContent()));
        result.setContent(activityDO);
        return result;
    }
}
