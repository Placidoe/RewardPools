package com.exploreX.domain.hotpool;

import com.exploreX.domain.hotpool.blance.LoadBlanceTemplate;
import com.exploreX.domain.hotpool.model.HotPoolNode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 下午3:56
 **/
@Service
public class HotPoolBoostrap {

    HotPool hotPool;
    HashMap<Integer, HotPoolNode> hotPoolNodeMap;

    @Resource
    LoadBlanceTemplate blanceTemplate;


    public void InitHotPoolBoostrap(){
        // 初始化热池
        this.hotPool = new HotPool();
    }

    @KafkaListener
    public void AddData(Object data){
        //路由到节点，起到负载均衡作用

    }

    public Integer getNextNodeIndex(){
        // 从热池中获取节点

        return 1;
    }

    public void PutData(Object Data){
        HotPoolNode hotPoolNode = hotPoolNodeMap.get(getNextNodeIndex());
        hotPoolNode.putData(Data);
    }
}
