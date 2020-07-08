package com.example.consumer.repository;

import com.example.consumer.pojo.es.Website;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/7 16:34
 * @Copyright:
 */
@Component
public interface ESWebsiteRepository extends ElasticsearchRepository<Website, Long> {
    Iterable<Website> findByName(String name);
}
