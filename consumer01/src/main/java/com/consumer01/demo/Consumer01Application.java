package com.consumer01.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
*  服务消费者
**/

@SpringBootApplication
@ComponentScan(basePackages={"com.consumer01.demo.*"})
public class Consumer01Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer01Application.class, args);
    }


}
