package com.sias.Order.Service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.sias.Order.Service.OrderService;
import com.sias.order.Bean.Order;
import com.sias.product.Bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceimpl implements OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Order creatOrder(Long productId , Long userId) {
        Product product =  getProductFromRemote(productId);//Order-->请求发送给Product--->拿到Product返回的price
        // 拿到的product对象大概是这样：
        // Product {
        //     id: 1001,
        //     name: "iPhone 17 Pro",
        //     price: 7999.00,
        //     num: 100,
        //     description: "最新款"
        // }
        Order order = new Order();
        order.setId(0L);
        //TODO 总金额逻辑待完善
        //BigDecimal total =  product.getPrice().multiply(new BigDecimal(product.getNum());   计算总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));//把总金额计算进去
        order.setUserId(0L);
        order.setNickName("伊橙");
        order.setAddress("伊橙");
        order.setProductList(Arrays.asList(product));

        return order;
    }
    private Product getProductFromRemote(Long productId) {
        //1、获取到商品服务所在的所有机器IP+Port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //TODO 这里需要优化，索引0意味着如果有多台服务器，第一台挂了第二台会顶上，但是其他服务器在第二台挂之前不会再服务，需要负载均衡
        ServiceInstance instance = instances.get(0);
        //远程URL
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;

        //2、给远程发送请求
        log.info("开始发送请求: {}", url.toString());
        Product product = restTemplate.getForObject(url, Product.class);//getForObject是发送get请求，url请求路径，返回的JSON自动转换为Product

        return product;
    }
}
