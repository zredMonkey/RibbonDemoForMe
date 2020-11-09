package com.provider01.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*  服务提供者
**/

@SpringBootApplication
public class Provider01Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider01Application.class, args);
    }

    @RestController
    static class TestController {

        private Logger logger = LoggerFactory.getLogger(TestController.class);

        @Value("${server.port}")
        private Integer serverPort;

        @GetMapping("/echo")
        public String echo() throws InterruptedException {
            // 模拟执行 100ms 时长。方便后续我们测试请求超时
            Thread.sleep(100L);

            // 记录被调用的日志
            logger.info("[echo][被调用啦 name({})]");

            logger.info("调用信息：  " + serverPort + "-provider: ");
            System.out.println("=======================调用信息：  " + serverPort + "-provider: ");
            // 返回带有服务器端口，在稍后服务消费者调用是可以知道是哪个实例在调用
            return serverPort + "-provider";
        }

        @GetMapping("/demoprovider/test")
        public String test() {
            System.out.println("=======================调用信息：  " + serverPort + "-provider: ");
            return "=======================调用信息：  " + serverPort + "-provider: ";
        }

    }

}
