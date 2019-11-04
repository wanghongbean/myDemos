package com.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoLogApplication {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoLogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoLogApplication.class, args);
        while (true) {
            LOGGER.debug("--时间-- ： {}", new Date());
        }

    }
}
