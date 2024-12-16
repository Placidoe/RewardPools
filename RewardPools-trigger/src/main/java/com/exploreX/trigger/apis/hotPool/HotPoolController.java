package com.exploreX.trigger.apis.hotPool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/12/16 下午4:33
 **/
@RequestMapping("/hotPool")
@RestController
@Api(tags = "热处理池")
public class HotPoolController {

    @ApiOperation("查看热处理池节点列表")
    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    @ApiOperation("查看热处理池节点详情")
    @RequestMapping("/detail")
    public String detail() {
        return "detail";
    }


    @ApiOperation("往指定节点里添加数据")
    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @ApiOperation("从指定节点里删除数据")
    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    @ApiOperation("清空指定节点")
    @RequestMapping("/clear")
    public String clear() {
        return "clear";
    }

    @ApiOperation("清空所有节点")
    @RequestMapping("/clearAll")
    public String clearAll() {
        return "clearAll";
    }

    @ApiOperation("查看热处理池节点状态")
    @RequestMapping("/status")
    public String status() {
        return "status";
    }

}
