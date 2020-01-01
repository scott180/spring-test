package com.xu.spring.test.common.query;

import lombok.Data;

/**
 * @author xu
 * @date 2020/1/1 13:31
 */
@Data
public class UserQuery extends BaseQuery {
    private String name;
    private String loginName;
}
