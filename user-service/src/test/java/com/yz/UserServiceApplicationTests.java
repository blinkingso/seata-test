package com.yz;

import com.yz.mapper.UserMapper;
import com.yz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        User user = new User();
        user.setName("n1");
        user.setAlias("n1");
        user.setPassword("n1");
        user.setBalance(100.00);

        int res = userMapper.save(user);
        System.out.println("保存结果为: " + res);
    }

}
