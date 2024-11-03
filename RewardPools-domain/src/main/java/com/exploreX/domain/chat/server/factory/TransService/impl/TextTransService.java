package com.exploreX.domain.chat.server.factory.TransService.impl;

import com.exploreX.domain.chat.server.factory.TransService.TransService;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:47
 **/
@Component(value = "text")
public class TextTransService implements TransService {
    @Override
    public void ParseAndSend(String msg, Session session, Map<String, Session> sessionMap) {

    }

    @Override
    public void broadcast(String msg,Map<String, Session> sessionMap) {

    }
    //解析并广播发送

}
