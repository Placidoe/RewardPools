package com.exploreX.trigger.apis.active;


import com.exploreX.types.common.ESIndexConstants;
import com.exploreX.types.model.pojo.Result;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/es")
@ApiOperation("ES文档操作")
public class ElasticsearchDocumentController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/createIndex")
    @ApiOperation("预热创建索引")
    Result<String> CreateIndex() throws IOException {
        // 1.准备Request      PUT /hotel
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        // 2.准备请求参数
        request.source(ESIndexConstants.MAPPING_TEMPLATE, XContentType.JSON);
        // 3.发送请求
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);

        return Result.success("创建索引成功");
    }


    @GetMapping("/createIndex")
    @ApiOperation("判断索引是否存在")
    Result<String> testExistsIndex(String indices) throws IOException {
        // 1.准备Request
        GetIndexRequest request = new GetIndexRequest(indices);
        // 3.发送请求
        boolean isExists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);

        System.out.println(isExists ? "存在" : "不存在");
        if (isExists) {
            return Result.success("索引存在");
        } else {
            return Result.success("索引不存在");
        }
    }

    @DeleteMapping("/deleteIndex")
    @ApiOperation("删除索引")
    Result<String> testDeleteIndex() throws IOException {
        // 1.准备Request
        DeleteIndexRequest request = new DeleteIndexRequest("hotel");
        // 3.发送请求
        restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);

        return Result.success("删除索引成功");
    }


}