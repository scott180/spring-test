package com.xu.spring.test.dal.mapper;

import com.xu.spring.test.dal.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @date 2019/12/29 12:22
 */

@Repository
public interface UserMapper {

    User selectById(Long id);


}
