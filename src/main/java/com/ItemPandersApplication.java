package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@ComponentScan("util.encode")
//@EnableWebSecurity
public class ItemPandersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemPandersApplication.class, args);
    }

}
