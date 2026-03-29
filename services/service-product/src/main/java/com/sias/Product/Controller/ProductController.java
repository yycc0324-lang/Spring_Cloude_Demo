package com.sias.Product.Controller;


import com.sias.Product.Bean.Product;
import com.sias.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//启用MVC注解
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    public Product getProduct(Long productId) {
        productService.getProduct(productId);
        //TODO 写完Service后需要修改返回数据为商品数据
        return null;
    }
}
