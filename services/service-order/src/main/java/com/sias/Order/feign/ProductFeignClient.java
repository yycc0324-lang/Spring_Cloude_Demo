package com.sias.Order.feign;
import com.sias.product.Bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "service-product")//说明这是一个发送远程调用请求的客户端,()里的内容就是你想要调用对方的微服务的名字
public interface ProductFeignClient {

    @GetMapping("/product/{id}")  //现在Get\Post\Put\Delete的Mapping在Controller中就是接收请求的，在FeignClient中就是发送请求的
                                    //void getProductbyId(@PathVariable("id") Long id, @RequestHeader("token") String token);
                                    //这里的Long id是把自己定义的id放到/product/{id}中发出去而不是像Controller中一样从路径中获取id
                                    //@RequestHeader("token") String token的意思是请求的时候给请求头一个 token
    Product getProductbyId(@PathVariable("id") Long id);//这里些Product是告诉对方返回的数据类型是自己定义的Product，写成String就会返回一个Json字符串

}
