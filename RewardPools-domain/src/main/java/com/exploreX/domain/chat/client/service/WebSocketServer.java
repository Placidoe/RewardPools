package com.exploreX.domain.chat.client.service;

import com.exploreX.domain.chat.model.MessageData;

import java.io.IOException;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("WebSocket connection opened: " + session.getId());

        session.addMessageHandler(new MessageHandler.Whole<Object>() {
            @Override
            public void onMessage(Object messageData) {
                //TODO 转化
                MessageData Data = (MessageData) messageData;
                System.out.println("Received message: " + Data.getMsg());

                try {
                    session.getBasicRemote().sendText("Server received message: " + Data.getMsg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket connection closed: " + session.getId() + " Reason: " + closeReason.getReasonPhrase());
    }

    @Override
    public void onError(Session session, Throwable throwable) {
        System.err.println("WebSocket error occurred: " + session.getId());
        throwable.printStackTrace();
    }

}
