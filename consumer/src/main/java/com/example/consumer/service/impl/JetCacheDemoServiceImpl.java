package com.example.consumer.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.consumer.service.IJetCacheDemoService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/7 15:48
 * @Copyright:
 */
@Component
public class JetCacheDemoServiceImpl implements IJetCacheDemoService {
    @CreateCache(name = "myServiceCache", expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    private Cache<String, String> cache;

    @Override
    public void createCacheDemo() {
        cache.put("myKey", "myKey");
        String myValue = cache.get("myKey");
        System.out.println("get 'myKey' from cache:" + myValue);
    }

    @Override
    public String readFromCacheDemo() {
        return cache.get("myKey");
    }
}
