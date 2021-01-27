package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author andrew
 * @date 2021-01-27 6:18 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SeataTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataTesterApplication.class, args);
    }
}
