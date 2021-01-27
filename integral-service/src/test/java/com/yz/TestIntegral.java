package com.yz;

import com.yz.dao.IntegralDao;
import com.yz.pojo.Integral;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andrew
 * @date 2021-01-27 1:52 PM
 */
@SpringBootTest
public class TestIntegral {

    @Autowired
    private IntegralDao integralDao;

    @Test
    public void testIntegral() {
        final Integral integral = new Integral();
        integral.setUserId(System.currentTimeMillis());
        integral.setType(1);
        integral.setUserName("blinkingso");
        integral.setNumbersOfIntegral(1000L);

        int res = integralDao.save(integral);
        System.out.println("积分新增结果: " + res);
    }
}
