package com.exploreX.test;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void testSearch() {
        // 构建查询
        SearchHits<MyDocument> searchHits = elasticsearchOperations.search(
            new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withPageable(PageRequest.of(0, 10))
                .build(),
            MyDocument.class
        );

        // 处理结果
        for (SearchHit<MyDocument> hit : searchHits) {
            System.out.println(hit.getContent());
        }
    }
}