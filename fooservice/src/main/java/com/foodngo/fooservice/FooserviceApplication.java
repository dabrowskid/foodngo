package com.foodngo.fooservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.foodngo")
@EnableWebMvc
public class FooserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FooserviceApplication.class, args);
    }
}
