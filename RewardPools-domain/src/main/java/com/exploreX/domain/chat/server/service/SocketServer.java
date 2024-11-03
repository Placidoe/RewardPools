package com.exploreX.domain.chat.server.service;

import com.alibaba.fastjson.JSON;

import com.exploreX.domain.chat.server.factory.TransFactory;
import com.exploreX.domain.chat.server.factory.TransService.TransService;
import com.exploreX.domain.chat.model.TransData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{username}")
@Component
@Slf4j
public class SocketServer {

    // 保存链接的session，key为用户名,value为对应的session名
    static private ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    @Resource
    private TransFactory transFactory;

    /**
     * 创建连接
     * 用于监听建立连接，当有客户端与该服务端点建立连接时，将会自回调该注解标注的方法
     * @param session
     * @param username
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "username") String username) {
        log.info("用户{}已创建连接", username);
        sessionMap.put(username,session);
        log.info("当前在线人数{}",sessionMap.size());
        sessionMap.forEach((k,v)->System.out.println(k));
    }


    /**
     * 用于监听客户端向服务端发送消息，当客户端与服务端发送消息时，将会回调该注解标注的方法
     * @param msg
     * @param username
     */
    @OnMessage
    public void onMessage(String msg,@PathParam(value = "username") String username){
        log.info("用户{}向服务端发来消息:{}",username,msg);
        TransData transData = JSON.parseObject(msg, TransData.class);
        int codeType = transData.getFlag();
        TransService transService = transFactory.getTransService(codeType);
        transService.ParseAndSend(msg,sessionMap.get(username),sessionMap);
    }


    /**
     * 用于监听连接关闭，当客户端与该服务端点断开连接时，将会回调该注解标注的方法
     * @param session
     * @param username
     */
    @OnClose
    public void onClose(Session session,@PathParam(value = "username") String username){
        log.info("用户{}已关闭连接", username);
        sessionMap.remove(username);
    }


    /**
     * 用于监听该连接上的任何错误，当客户端与该服务端点的连接发生任何异常，都将回调该注解标注的方法
     * 注意该方法的参数必选Throwable，可选Sessiion以及0-n个String参数，且String参数需要使用@PathParam注解标注
     * @param throwable
     * @param username
     */
    @OnError
    public void onError(Throwable throwable,@PathParam(value = "username") String username){
        log.error("用户{}连接发生异常", username);
    }


    /**
     * 用来发送消息的方法，参数分别为接收消息的用户的session，和对应的消息
     */
    private void sendMessage(Session toSession,String msg){
        try {
            toSession.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
