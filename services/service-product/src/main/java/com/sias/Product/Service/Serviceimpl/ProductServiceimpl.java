package com.sias.Product.Service.Serviceimpl;


import com.sias.Product.Service.ProductService;
import com.sias.product.Bean.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceimpl implements ProductService {
    @Override
    public Product getProductByid(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setProductName("iphone");
        product.setNum(100);
        product.setPrice(new BigDecimal(10000));
        return product;
    }
}
