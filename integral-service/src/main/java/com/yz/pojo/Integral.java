package com.yz.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 积分
 *
 * @author andrew
 * @date 2021-01-27 11:32 AM
 */
@Data
@NoArgsConstructor
public class Integral {

    /**
     * 积分id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 积分类型
     */
    private Integer type;
    /**
     * 积分个数
     */
    private Long numbersOfIntegral;
}
