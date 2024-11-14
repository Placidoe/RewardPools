package com.exploreX.trigger.apis.active;

import com.exploreX.domain.active.upAndDownActive.service.UpAndDownActiveService;
import com.exploreX.types.enums.ResponseCode;
import com.exploreX.types.model.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/7 下午10:33
 **/
@RequestMapping("/active")
@RestController
@Slf4j
public class DCCValueActiveStatusController {



    @Resource
    private CuratorFramework client;

    @Resource
    UpAndDownActiveService upAndDownActiveService;

    /*触发*/
    @PostMapping("/doUp")
    public Response<Boolean> doUpActive(/*active*/String key , String value) {

        upAndDownActiveService.upActive(key,value);

        return Response.<Boolean>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .build();
    }




    @PostMapping("/doDown")
    public Response<Boolean> doDownActive(/*active*/String key , String value) {



        //TODO 聚合并关闭影子表

        //TODO 修改Zookeeper活动名称



        return Response.<Boolean>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .build();
    }





}
