package com.yz.service;

import com.yz.pojo.User;

import java.util.List;

/**
 * @author andrew
 * @date 2021-01-27 3:30 PM
 */
public interface UserService {

    /**
     * 生成新用户列表
     *
     * @param toSaveList 新用户列表
     * @return 保存的记录总数
     */
    int createUsers(List<User> toSaveList);
}
