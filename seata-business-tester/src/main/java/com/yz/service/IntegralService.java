package com.yz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author andrew
 * @date 2021-01-27 6:23 PM
 */
@Component
@FeignClient(name = "INTEGRAL-SERVICE", path = "integral")
public interface IntegralService {

    /**
     * @param integrals 积分记录
     * @return 新增的记录数
     */
    @PostMapping
    ResponseEntity<Integer> newIntegral(@RequestBody List<Map<String, String>> integrals);
}
