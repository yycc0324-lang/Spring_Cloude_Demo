package com.sias.Order.Controller;
import com.sias.Order.Service.OrderService;
import com.sias.order.Bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public String Createorder(@RequestParam Long productId, Long userId) {
         orderService.creatOrder(productId, userId);
         Order order = orderService.creatOrder(productId,userId);
        return "order created" + order.toString();
    }
}
