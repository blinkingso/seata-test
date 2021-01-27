package com.yz.controller;

import com.yz.pojo.User;
import com.yz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andrew
 * @date 2021-01-27 3:52 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Integer> newUsers(@RequestBody List<String> users) {
        if (CollectionUtils.isEmpty(users)) {
            return ResponseEntity.ok(0);
        }
        List<User> userList = users.stream().map(userName -> {
            final User user = new User();
            user.setName(userName);
            user.setPassword("123456");
            user.setAlias(userName + "_alias");
            user.setBalance(1000d);
            return user;
        }).collect(Collectors.toList());

        try {
            int saved = userService.createUsers(userList);
            return ResponseEntity.ok().body(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(0);
        }
    }
}
