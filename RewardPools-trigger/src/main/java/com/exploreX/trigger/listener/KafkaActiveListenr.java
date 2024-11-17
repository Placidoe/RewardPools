package com.exploreX.trigger.listener;

import com.exploreX.types.common.KafkaActiveConstants;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/17 上午1:35
 **/
public class KafkaActiveListenr {

    //TODO 异步预热
    @KafkaListener(topics = KafkaActiveConstants.topic)
    public void SKUListen(String activeId) {
        //预热SKU数据
    }


    @KafkaListener(topics = KafkaActiveConstants.topic)
    public void STRAGETYListen(String activeId) {
        //预热策略数据
    }

    @KafkaListener(topics = KafkaActiveConstants.topic)
    public void TOPICListen(String activeId) {
        //预热TOPIC数据
    }

    @KafkaListener(topics = KafkaActiveConstants.topic)
    public void TOKENListen(String activeId) {
        //预热令牌桶

    }
}
