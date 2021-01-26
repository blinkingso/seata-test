package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author andrew
 * @date 2021-01-26 3:52 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class IntegralServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegralServiceApplication.class, args);
    }
}
