package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/6 11:42
 * @Copyright:
 */
@FeignClient(name = "provider")
public interface IProviderService {

    @RequestMapping(value = "/getProvider", method = RequestMethod.GET)
    String getProvider();

}
