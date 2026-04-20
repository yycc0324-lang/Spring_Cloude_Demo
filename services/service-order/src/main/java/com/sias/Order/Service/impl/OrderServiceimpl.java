package com.sias.Order.Service.impl;
import java.math.BigDecimal;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;

import com.sias.Order.Service.OrderService;
import com.sias.order.Bean.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl implements OrderService {
    @Override
    public com.sias.order.Bean.Order creatOrder(Long productId , Long userId) {
        Order order = new Order();
        order.setId(0L);
        //TODO 总金额逻辑待完善
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(0L);
        order.setNickName("伊橙");
        order.setAddress("伊橙");
        order.setProductList(Lists.newArrayList());

        return order;
    }
}
