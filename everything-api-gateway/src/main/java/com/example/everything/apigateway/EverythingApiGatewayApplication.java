package com.example.everything.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author win10
 */
@SpringBootApplication
@EnableZuulProxy
public class EverythingApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverythingApiGatewayApplication.class, args);
    }

}

