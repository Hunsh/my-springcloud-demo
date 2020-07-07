package com.example.consumer.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.consumer.service.IJetCacheDemoService;
import com.example.consumer.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/6 11:41
 * @Copyright:
 */

@RefreshScope
@RestController
public class ConsumerController {
    @Value("${consumer:defaultConsumer}")
    private String consumer;

    @Autowired
    private IProviderService providerService;
    @Autowired
    private IJetCacheDemoService jetCacheDemoService;

    @GetMapping("/getConsumer")
    public String getConsumer(){
        return "consumer:"+consumer+" provider:"+providerService.getProvider();
    }

    @PostMapping("/addCache")
    public void addCache(){
        jetCacheDemoService.createCacheDemo();
    }

    @GetMapping("/getCache")
    public String getCache(){
        return "result:"+jetCacheDemoService.readFromCacheDemo();
    }




}
