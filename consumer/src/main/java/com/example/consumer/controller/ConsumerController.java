package com.example.consumer.controller;

import com.example.consumer.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IProviderService iProviderService;

    @GetMapping("/getConsumer")
    public String getConsumer(){
        return "consumer:"+consumer+" provider:"+iProviderService.getProvider();
    }

}
