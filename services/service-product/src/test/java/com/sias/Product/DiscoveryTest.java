package com.sias.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootTest

public class DiscoveryTest {
    @Autowired
    private DiscoveryClient discoveryClient;//注入发现注册中心的DiscoveryClient

    @Test
     void Text_Client_Service() {
       for (String serviceName : discoveryClient.getServices()) {

           System.out.println(serviceName);
//一堆乱码
//           System.out.println("ip"+discoveryClient.getInstances(serviceName).toString());
//           System.out.println("port"+discoveryClient.getInstances(serviceName).toString());
       }

    }
}
