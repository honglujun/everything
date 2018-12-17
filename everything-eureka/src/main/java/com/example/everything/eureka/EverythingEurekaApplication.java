package com.example.everything.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author win10
 */
@SpringBootApplication
@EnableEurekaServer
public class EverythingEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverythingEurekaApplication.class, args);
    }

}

