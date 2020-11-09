package com.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
*  访问 http://127.0.0.1:8888/user-service/user/get?id=1 地址
**/

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        RouteLocator build = builder.routes()
//                .route(p -> p
//                        .path("/user-service/**")
//                        .filters(f -> f.rewritePath("/user-service/(?<remaining>.*)", "/${remaining}"))
//                        .uri("lb://user-service"))
//                .build();
//        System.out.println("===========================");
//        return build;
//    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        List<String> serviceIds = new ArrayList<>(1);
        serviceIds.add("demoprovider");
        System.out.println(serviceIds);
        serviceIds.forEach((path) -> {
            routes.route(path, r -> r.path("/" + path + "/**")
                    .filters(GatewayFilterSpec::preserveHostHeader)
                    .uri("lb://cosmo-" + path));
        });
        return routes.build();
    }

}
