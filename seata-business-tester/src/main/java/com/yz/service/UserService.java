package com.yz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author andrew
 * @date 2021-01-27 6:22 PM
 */
@Component
@FeignClient(name = "USER-SERVICE", path = "/user")
public interface UserService {

    /**
     * 用户接口
     *
     * @param users 用户名称列表
     * @return 结果
     */
    @PostMapping
    ResponseEntity<Integer> newUsers(@RequestBody List<String> users);

    /**
     * 通过用户名查询userId
     *
     * @param userName 用户名
     * @return 用户id
     */
    @GetMapping("/{userName}")
    ResponseEntity<Long> queryUserIdViaUserName(@PathVariable("userName") String userName);
}
