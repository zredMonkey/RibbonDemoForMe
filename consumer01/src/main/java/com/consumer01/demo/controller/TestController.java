package com.consumer01.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *  代码备注：
 *     虽然 /hello02 接口相比 /hello 接口只精简了一行代码，但是它带来的不仅仅是表面所看到的。
 *     例如说，如果我们调用服务的一个实例失败时，想要重试另外一个示例，就存在了很大的差异。
 *
 *     /hello02 接口的方式，可以自动通过 LoadBalancerClient 重新选择一个该服务的实例，再次发起调用。
 *     /hello 接口的方式，需要自己手动写逻辑，使用 LoadBalancerClient 重新选择一个该服务的实例，后交给 RestTemplate 再发起调用。
 **/

@RestController
public class TestController {


    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     *  负载均衡客户端
     *  稍后我们会使用它，从 Nacos 获取的服务 demo-provider 的实例列表中，选择一个进行 HTTP 调用。
     **/
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(String name) {
        // 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance = loadBalancerClient.choose("demo-provider");
        // 发起调用
        String targetUrl = instance.getUri() + "/echo?name=" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "consumer:" + response;
    }

    @GetMapping("/hello02")
    public String hello02() {
        // 要注意，在使用 @LoadBalanced 注解的 RestTemplate Bean 发起 HTTP 请求时，需要将原本准备传入的 host:port 修改成服务名，
        //     例如这里我们传入了 demo-provider。
        // 直接使用 RestTemplate 调用服务 `demo-provider`
        String targetUrl = "http://cosmo-demoprovider/demoprovider/test";
        String response = restTemplate.getForObject(targetUrl, String.class);
        System.out.println(response);
        // 打印结果
        logger.info("onsumer:   " + response);
        // 返回结果
        return "consumer:" + response;
    }


    @GetMapping("/hello03")
    public String hello03() {
        // 要注意，在使用 @LoadBalanced 注解的 RestTemplate Bean 发起 HTTP 请求时，
        // 需要将原本准备传入的 host:port 修改成服务名，
        //     例如这里我们传入了 demo-provider。
        // 直接使用 RestTemplate 调用服务 `demo-provider`
        String targetUrl = "http://cosmo-cag-ribbon-test/test";
        String response = restTemplate.getForObject(targetUrl, String.class);
        System.out.println("consumer:   " + response);
        // 返回结果
        return "被调用了   ：  " + response;
    }

    @GetMapping("/helloworld")
    public String hellowWorld() {
        return "helloWorld~";
    }
}
