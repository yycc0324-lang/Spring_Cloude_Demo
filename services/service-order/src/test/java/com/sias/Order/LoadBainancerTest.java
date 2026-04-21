package com.sias.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBainancerTest {
    // 方式1：使用 LoadBalancerClient（需要确认版本支持）
    @Autowired
    private LoadBalancerClient loadBalancerClient;

@Test
    void test(){
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        System.out.println("choose="+  choose.getHost()+choose.getPort());
        choose =  loadBalancerClient.choose("service-product");
        System.out.println("choose="+  choose.getHost()+choose.getPort());
        choose =  loadBalancerClient.choose("service-product");
        System.out.println("choose="+  choose.getHost()+choose.getPort());
        choose =  loadBalancerClient.choose("service-product");
        System.out.println("choose="+  choose.getHost()+choose.getPort());
        choose =  loadBalancerClient.choose("service-product");
        System.out.println("choose="+  choose.getHost()+choose.getPort());
        choose =  loadBalancerClient.choose("service-product");
    }
}
