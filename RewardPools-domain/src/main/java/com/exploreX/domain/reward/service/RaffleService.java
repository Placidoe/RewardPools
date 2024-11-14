package com.exploreX.domain.reward.service;

import com.exploreX.types.model.pojo.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/5 上午1:01
 **/
public interface RaffleService {

    //抽奖
    public Result raffle(HttpServletRequest request);
    //预热
    public Result warmUp();
    //奖池开奖(时间到或者奖池满了)
    public Result openDrawPool();
}
