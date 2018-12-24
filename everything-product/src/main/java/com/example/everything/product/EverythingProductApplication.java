package com.example.everything.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author win10
 */
@SpringBootApplication
@EnableFeignClients
public class EverythingProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverythingProductApplication.class, args);
    }

}

