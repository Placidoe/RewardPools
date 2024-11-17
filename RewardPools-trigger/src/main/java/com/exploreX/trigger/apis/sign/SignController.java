package com.exploreX.trigger.apis.sign;

import com.exploreX.domain.sign.service.SignService;
import com.exploreX.types.model.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午6:52
 **/
@RestController
@RequestMapping("/sign")
public class SignController {

    @Resource
    private SignService signService;
    /*签到*/
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public Result sign(HttpServletRequest request) {
        return signService.sign(request);
    }

    /*统计签到次数*/
    @RequestMapping(value = "/check/count",method = RequestMethod.GET)
    public Result signCount(HttpServletRequest request) {
        return signService.signCount(request);
    }


    @RequestMapping(value = "/count/reward",method = RequestMethod.GET)
    public Result signCountReward(int count) {
        return signService.signCountReward();
    }
}
