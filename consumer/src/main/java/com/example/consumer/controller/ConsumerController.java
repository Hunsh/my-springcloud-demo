package com.example.consumer.controller;

import com.example.consumer.pojo.es.Website;
import com.example.consumer.repository.ESWebsiteRepository;
import com.example.consumer.service.IJetCacheDemoService;
import com.example.consumer.service.IProviderService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    ESWebsiteRepository websiteRepository;

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



    @PostMapping("/es/insert")
    public ResponseEntity loadWebsite(){
        Website website1 = new Website(1L,"objectId1", "中国信息网站", "parentObjectId", "desc1", "linkUrl1", "icon1");
        Website website2 = new Website(2L,"objectId2", "遥感交流网站", "parentObjectId", "desc2", "linkUrl2", "icon2");

        websiteRepository.save(website1);
        websiteRepository.save(website2);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/es/search")
    public ResponseEntity searchWebsite(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", "中遥站"));
        // 添加基本分词查询
        Page<Website> websites = websiteRepository.search(queryBuilder.build());

        return ResponseEntity.ok(true);
    }








}
