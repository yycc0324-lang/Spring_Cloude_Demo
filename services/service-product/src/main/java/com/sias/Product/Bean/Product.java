package com.sias.Product.Bean;
//DTO中的class一般不会进行数据处理，需要处理的就写在Bean
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private BigDecimal price;
    private int num;    //商品数量
    private String productName;
}
