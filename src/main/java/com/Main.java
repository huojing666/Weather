package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration //启动bean自动注入
@ComponentScan //启动自动搜索bean
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class);
    }
}
