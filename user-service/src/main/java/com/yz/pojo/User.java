package com.yz.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author andrew
 * @date 2021-01-26 5:19 PM
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private String password;
    private String alias;
    private Double balance;
}
