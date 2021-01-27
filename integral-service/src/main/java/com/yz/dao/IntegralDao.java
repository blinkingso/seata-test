package com.yz.dao;

import com.yz.pojo.Integral;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author andrew
 * @date 2021-01-27 11:31 AM
 */
@Mapper
public interface IntegralDao {

    /**
     * 新增积分记录
     *
     * @param integral 积分
     * @return 1/0
     */
    int save(@Param("integral") Integral integral);

    /**
     * 增加积分
     *
     * @param integral 增加的积分数
     * @param userId   用户id
     * @return 1/0
     */
    int incrementByUserId(@Param("integral") Long integral, @Param("userId") Long userId);
}
