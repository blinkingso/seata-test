package com.yz;

import com.yz.pojo.Integral;
import com.yz.service.IntegralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andrew
 * @date 2021-01-27 6:31 PM
 */
@RestController
@RequestMapping("/integral")
public class IntegralController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegralController.class);

    private final IntegralService integralService;

    public IntegralController(IntegralService integralService) {
        this.integralService = integralService;
    }

    @PostMapping("")
    public ResponseEntity<Integer> newIntegral(@RequestBody List<Map<String, String>> integrals) {
        if (integrals.isEmpty()) {
            return ResponseEntity.ok(0);
        }
        List<Integral> list = integrals.stream().map(map -> {
            try {
                final Integral integral = new Integral();
                integral.setUserName(map.getOrDefault("userName", "user_" + System.currentTimeMillis()));
                integral.setUserId(Long.parseLong(map.get("userId")));
                integral.setNumbersOfIntegral(1000L);
                integral.setType(1);
                return integral;
            } catch (Exception e) {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());

        try {
            int res = integralService.createIntegral(list);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(0);
        }
    }
}
