package com.sias.Order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderServiceConfig {

    @LoadBalanced//TODO 加了这个注释后使用 restTemplate 请求后都会自动负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
