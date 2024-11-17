package com.exploreX.domain.sign.service;

import com.exploreX.types.model.pojo.Result;
import javax.servlet.http.HttpServletRequest;


/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午7:02
 **/
public interface SignService {
    public Result sign(HttpServletRequest request) ;

    public Result signCount(HttpServletRequest request) ;

    public Result signCountReward();
}
