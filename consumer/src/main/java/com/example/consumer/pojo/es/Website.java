package com.example.consumer.pojo.es;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @description:
 * @author: Jdz
 * @create: 2020/7/7 16:28
 * @Copyright:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "index_of_website", type = "doc")
public class Website {
    @Id
    private Long id;
    private String objectId;
    @Field(searchAnalyzer = "ik_smart",analyzer = "ik_max_word")
    private String name;
    private String parentObjectId;
    private String desc;
    private String linkUrl;
    private String icon;
}
