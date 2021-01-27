package com.yz.service;

/**
 * @author andrew
 * @date 2021-01-27 6:19 PM
 */
public interface BusinessService {

    /**
     * 注册新用户
     *
     * @param userName 用户名
     * @return 注册结果
     */
    boolean register(String userName);
}
