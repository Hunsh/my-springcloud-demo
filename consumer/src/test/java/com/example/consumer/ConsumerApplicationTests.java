package com.example.consumer;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.example.consumer")
public class ConsumerApplicationTests {

    class Coffee{
        private int id;
        private String name;

        public Coffee(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static final String CACHE_NAME = "coffee_cache";

    @CreateCache(name = CACHE_NAME, expire = 1, localLimit = 10,
            timeUnit = TimeUnit.MINUTES, cacheType = CacheType.REMOTE)
    private Cache<Integer, Coffee> testCoffeeCache;

    @Test
    public void add(){
        Coffee coffee1 = new Coffee(1, "first");
        Coffee coffee2 = new Coffee(2, "second");
        testCoffeeCache.put(coffee1.getId(), coffee1, 10, TimeUnit.MINUTES);
        System.out.println("id1 : "+testCoffeeCache.get(1));
        testCoffeeCache.put(coffee2.getId(), coffee2, 20, TimeUnit.MINUTES);
        System.out.println("id2 : "+testCoffeeCache.get(2));
    }

    @Test
    public void read(){
        System.out.println("id1 : "+testCoffeeCache.get(1));
        System.out.println("id2 : "+testCoffeeCache.get(2));
    }




}
