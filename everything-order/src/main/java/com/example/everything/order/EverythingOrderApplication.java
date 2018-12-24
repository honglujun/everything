package com.example.everything.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author win10
 */
@SpringBootApplication
@EnableFeignClients
public class EverythingOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverythingOrderApplication.class, args);
    }

}

