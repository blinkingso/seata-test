package com.yz.service;

import com.yz.pojo.Integral;

import java.util.List;

/**
 * @author andrew
 * @date 2021-01-27 2:24 PM
 */
public interface IntegralService {

    /**
     * 新增积分记录
     * @return int
     */
    int createIntegral(List<Integral> toSave);
}
