package com.exploreX.infrastructure.mq;

import com.alibaba.fastjson2.JSON;
import com.exploreX.domain.chat.model.TransData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午4:33
 **/
public class ExchangeListener {


    @KafkaListener(topics = "exchange")
    @Transactional
    public void listenExchange(String message) {
        TransData transData = JSON.parseObject(message, TransData.class);
        //扣除A用户碎片

        //增加B用户碎片

    }

    @KafkaListener(topics = "deday_exchange")
    public void listenDelayExchange(String message){

    }
}
