package com.example;

import com.example.service.SocialNetworkService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ConnectionsConsole {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        SocialNetworkService socialNetworkService=context.getBean(SocialNetworkService.class);
    }
}
