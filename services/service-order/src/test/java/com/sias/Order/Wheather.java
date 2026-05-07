package com.sias.Order;

import com.sias.Order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Wheather {
    @Autowired
    private WeatherFeignClient weatherFeignClient;
    @Test
    void test(){
        String weather = weatherFeignClient.getWeather("APPCODE YOUR_APPCODE", "YOURTOKEN", "YOUR_CITYID");
        System.out.println(weather);
    }
}
