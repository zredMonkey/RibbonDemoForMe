package com.consumer01.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhouhongzhan
 * @description:
 * @date: 2020/10/28 19:55
 **/
@Configuration
public class RestTemplateConfiguration {

    // 声明 RestTemplate Bean 被配置使用 Spring Cloud LoadBalancerClient（负载均衡客户端），实现在请求目标服务时，
    // 能够进行负载均衡。
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
