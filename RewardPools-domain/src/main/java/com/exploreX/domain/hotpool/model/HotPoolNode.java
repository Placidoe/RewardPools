package com.exploreX.domain.hotpool.model;

import com.exploreX.domain.hotpool.service.MyMethodService;
import org.springframework.context.event.EventListener;

import java.util.HashMap;

/**
  * TODO
  *
  * @Description
  * @Author Lx
  * @Date 2024/11/17 下午4:11
  **/
public class HotPoolNode {
    //数据
    HashMap<String,Object> params;
    //回调方法
    MyMethodService myMethodService;
    @EventListener
    public void putData(Object data) {
        if(params.size()==4){
            myMethodService.run();//开始下发奖品、积分增加、流水记录等
        }
    }
}
