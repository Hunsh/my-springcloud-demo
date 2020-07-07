package com.example.consumer;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.example.consumer")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
