package com.exploreX.domain.chat.server.factory.TransService;

import javax.websocket.Session;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author 1
 * @Date 2024/11/3 下午2:55
 **/
public interface TransService {

    public void ParseAndSend(String msg, Session session, Map<String, Session> sessionMap);


    public void broadcast(String msg,Map<String, Session> sessionMap);


}
