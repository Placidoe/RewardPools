package com.exploreX.domain.chat.server.service;

import com.alibaba.fastjson2.JSON;
import com.exploreX.domain.chat.model.PieceExchangeData;
import com.exploreX.domain.chat.repository.IChatRepository;
import com.exploreX.domain.user.model.UserInfo;
import com.exploreX.types.common.TransConstans;
import com.exploreX.types.utils.SnowflakeUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @Description 碎片交换服务
 * @Author Lx
 * @Date 2024/11/3 下午3:16
 **/
@Component
public class WishPieceServer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedissonClient redissonClient;


    @Resource
    IChatRepository iChatRepository;

    @Resource
    SnowflakeUtil snowflakeUtil;

    //帮助他人许愿，许愿成功可返积分
    public void wishPiece(PieceExchangeData pieceExchangeData, UserInfo userInfo) throws InterruptedException {

    }
}


