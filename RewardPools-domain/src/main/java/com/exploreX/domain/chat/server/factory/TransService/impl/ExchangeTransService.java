package com.exploreX.domain.chat.server.factory.TransService.impl;

import com.alibaba.fastjson.JSON;
import com.exploreX.domain.chat.server.factory.TransService.TransService;
import com.exploreX.domain.chat.model.PieceExchangeData;
import com.exploreX.domain.chat.model.TransData;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:47
 **/
@Component(value = "exchange")
public class ExchangeTransService implements TransService {



    //解析并广播发送
    public void ParseAndSend(String msg , Session session, Map<String, Session> sessionMap){
        TransData transData = JSON.parseObject(msg, TransData.class);
        PieceExchangeData pieceExchangeData = transData.getPieceExchangeData();
        //广播碎片交换消息到会话上
        broadcast(transData.toString(),sessionMap);

        //异步产生一个交换碎片的任务落库


        //发起一个延迟队列去检查任务状态




    }

    public void broadcast(String msg,Map<String, Session> sessionMap) {

        sessionMap.forEach((k,v)->{
            sendMessage(v,msg);
        });
    }
    private void sendMessage(Session toSession,String msg){
        try {
            toSession.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
