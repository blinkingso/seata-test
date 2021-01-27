package com.yz.service.impl;

import com.yz.mapper.UserMapper;
import com.yz.pojo.User;
import com.yz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author andrew
 * @date 2021-01-27 3:32 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int createUsers(List<User> toSaveList) {
        LOGGER.info("开始保存用户记录....");
        int size = toSaveList.size();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        // 保存记录
        toSaveList.forEach(userMapper::save);
        LOGGER.info("用户记录保存成功..." + size + "条记录...");
        return size;
    }
}
