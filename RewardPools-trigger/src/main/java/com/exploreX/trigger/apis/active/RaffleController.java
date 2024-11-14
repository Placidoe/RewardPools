package com.exploreX.trigger.apis.active;

import com.exploreX.types.model.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/7 下午11:13
 **/
@RestController
@RequestMapping("raffle")
@Slf4j
public class RaffleController {

    @GetMapping("/preheatStrategy")
    public void preheatStrategy(String strategyId) {
        log.info("预热策略");
    }

    @GetMapping("/preheatActive")
    public void preheat(String ActiveId) {
        log.info("预热活动");
    }


    /*抽奖*/
    public Response<Integer> Raffle(){

        return null;
    }



    /*查看抽奖历史*/
    public Response<List<Integer>> RaffleHistory(){
        return null;
    }

    /*红包雨*/
    public Response<Integer> RedRain(){
        return null;
    }


}
