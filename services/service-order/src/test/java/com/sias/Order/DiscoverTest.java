package com.sias.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import java.util.List;
//测试类需要和正式类包名一模一样，否则注入类进不来，遵循SpringBoot测试包扫描规则
@SpringBootTest
public class DiscoverTest {
    @Autowired
    private DiscoveryClient discoveryClient;//这个DiscoveryClient 是 Spring Cloud 官方定义的一个核心接口
    @Test
    void testDiscover() {
            //service 可以获取模块名称
            for (String service : discoveryClient.getServices()){
                System.out.println("Name 喵"+service);
            }
            //获取 port 和 IP 需要用到另一个方法
            for (String service : discoveryClient.getServices()){
                System.out.println("Port_IP"+discoveryClient.getInstances(service));
                List<ServiceInstance> instances = discoveryClient.getInstances(service);
                for (ServiceInstance instance : instances) {
                    System.out.println("IP 、Port 喵：" + instance.getHost() + ":" + instance.getPort());
                }
            }
        }
    }

