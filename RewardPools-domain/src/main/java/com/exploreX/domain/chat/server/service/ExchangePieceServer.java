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
public class ExchangePieceServer {

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
    public void exchangePiece(PieceExchangeData pieceExchangeData, UserInfo userInfo) throws InterruptedException {

        //查看redis该碎片是否锁定
        //-----redistemplate.opsforValue().get!=null，说明已经锁定，直接返回
        String exchangePiece = redisTemplate.opsForValue().get(TransConstans.TRANSFER_EXCHANGE + pieceExchangeData.getPieceData().getPieceid());
        if(exchangePiece != null){
            return;
        }
        RLock lock = redissonClient.getLock(TransConstans.TRANSFER_EXCHANGE + pieceExchangeData.getPieceData().getPieceid());
        //redis锁定这个碎片
        //------锁定该碎片
        lock.tryLock(5000,  TimeUnit.MILLISECONDS);
        //异步处理REDIS碎片状态(定时器定时同步碎片状态到缓存中)和DB碎片任务状态，并且清除redis中该碎片(当发现缓存中没有该碎片，说明已经被交换了)
        kafkaTemplate.send("exchangePiece", JSON.toJSONString(pieceExchangeData));
        //-----状态表记录任务状态，补偿

        //-----解锁该碎片，添加到redis缓存
        redisTemplate.opsForValue().set(TransConstans.TRANSFER_EXCHANGE + pieceExchangeData.getPieceData().getPieceid(), "1");
        lock.unlock();
    }

    //获取碎片交换单信息详情
    public PieceExchangeData getPieceExchangeData(String exchangeid){
        return iChatRepository.getPieceExchangeDataByid(exchangeid);
    }


    //发送碎片交换请求
    public void sendExchangePieceRequest(PieceExchangeData pieceExchangeData, UserInfo userInfo) throws InterruptedException {
        //发送碎片交换请求
        //1.构造分布式id
        long exchangeId = snowflakeUtil.nextId();
        //2.落库
        iChatRepository.savePieceExchangeData(pieceExchangeData, exchangeId);
        //3.延迟队列查库
        kafkaTemplate.send("exchange_deley", String.valueOf(exchangeId));
    }

    //全量拉取已发出的交换的碎片列表
    public List<PieceExchangeData> getExchangePieceList(UserInfo userInfo){
        return Arrays.asList();
    }

}


