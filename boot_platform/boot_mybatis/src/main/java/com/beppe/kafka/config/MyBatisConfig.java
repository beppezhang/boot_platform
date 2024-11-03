package com.beppe.kafka.config;

import com.beppe.kafka.plugins.MyInterceptor;
import com.beppe.kafka.service.CityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    public MyInterceptor myInterceptor(CityService cityService) {
        return new MyInterceptor(cityService);
    }

}
