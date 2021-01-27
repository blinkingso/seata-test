package com.yz.service.impl;

import com.yz.service.BusinessService;
import com.yz.service.IntegralService;
import com.yz.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author andrew
 * @date 2021-01-27 6:42 PM
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServiceImpl.class);

    private final UserService userService;
    private final IntegralService integralService;

    public BusinessServiceImpl(UserService userService, IntegralService integralService) {
        this.userService = userService;
        this.integralService = integralService;
    }

    @Override
    public boolean register(String userName) {
        LOGGER.info("准备注册用户");
        if (StringUtils.isEmpty(userName)) {
            LOGGER.warn("用户名为空, 注册失败...");
            return false;
        }

        final List<String> users = List.of(userName);

        ResponseEntity<Integer> res1 = userService.newUsers(users);
        if (res1.getStatusCode() == HttpStatus.OK) {
            Long userId = userService.queryUserIdViaUserName(userName).getBody();
            if (null == userId || 0L == userId) {
                throw new IllegalStateException("用户记录保存失败");
            }
            List<Map<String, String>> integrals = List.of(Map.of("userName", userName, "userId", userId.toString()));
            ResponseEntity<Integer> res2 = integralService.newIntegral(integrals);
        }

        LOGGER.info("注册用户成功啦...");
        return true;
    }
}
