package com.xu.spring.test.service.dto;

import com.xu.spring.test.dal.model.UserActivityDO;
import lombok.Data;

/**
 * @author xu
 * @date 2020/1/1 22:15
 */
@Data
public class UserActivityDTO extends UserActivityDO {
    private String cancelText;
}
