package com.example.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/6 11:36
 * @Copyright:
 */
@RefreshScope
@RestController
public class ProviderController {

    @Value("${provider: defaultProvider}")
    private String provider;

    @GetMapping("/getProvider")
    public String getProvider(){
        return provider;
    }

}
