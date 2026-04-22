package com.sias.Order.properties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "order")//自动扫描order.后面有关下方的属性然后赋给OrderProperties对象，需要你写驼峰命名法给（如nacos中db-url写的话就是dbUrl）
@Data
@NoArgsConstructor
@AllArgsConstructor//构造函数
public class OrderProperties {

    String timeout;
    String autoConfirm; //nacos配置在properties中写成驼峰名法
    String dbUrl;

}
