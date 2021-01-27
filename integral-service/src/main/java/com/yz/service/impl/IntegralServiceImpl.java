package com.yz.service.impl;

import com.yz.dao.IntegralDao;
import com.yz.pojo.Integral;
import com.yz.service.IntegralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author andrew
 * @date 2021-01-27 3:15 PM
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class IntegralServiceImpl implements IntegralService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegralServiceImpl.class);

    private final IntegralDao integralDao;

    public IntegralServiceImpl(IntegralDao integralDao) {
        this.integralDao = integralDao;
    }

    @Override
    public int createIntegral(List<Integral> toSave) {
        int size = toSave.size();
        LOGGER.info("开始保存积分记录...");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        toSave.forEach(integralDao::save);
        LOGGER.info("积分记录保存成功..." + size + "条记录...");
        toSave.clear();
        return size;
    }
}
