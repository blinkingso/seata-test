package com.yz.mapper;

import com.yz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author andrew
 * @date 2021-01-26 5:17 PM
 */
@Mapper
public interface UserMapper {

    int save(@Param("user") User user);
}
