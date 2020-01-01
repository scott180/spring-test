package com.xu.spring.test.service.impl;

import com.xu.spring.test.common.Page;
import com.xu.spring.test.common.Result;
import com.xu.spring.test.common.util.CopyUtil;
import com.xu.spring.test.dal.mapper.UserActivityDOMapper;
import com.xu.spring.test.dal.model.UserActivityDO;
import com.xu.spring.test.dal.query.UserActivityQuery;
import com.xu.spring.test.service.UserActivityService;
import com.xu.spring.test.service.dto.UserActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xu
 * @date 2020/1/1 22:16
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserActivityDOMapper userActivityDOMapper;

    @Override
    public Result queryUserActivityList(UserActivityQuery query) {
        Long count = userActivityDOMapper.queryUserActivityListCount(query);
        Result result = new Result();
        if (count > 0) {
            List<UserActivityDO> list = userActivityDOMapper.queryUserActivityList(query);
            List<UserActivityDTO> dtoList = CopyUtil.copyPropertiesList(list, UserActivityDTO.class);
            dtoList.stream().forEach(userActivityDTO -> {
                userActivityDTO.setCancelText("1".equals(userActivityDTO.getCancel()) ? "是" : "否");
            });
            Page page = new Page(query.getCurrentPage(), count, dtoList);
            result.setContent(page);
        }
        return result;
    }
}
