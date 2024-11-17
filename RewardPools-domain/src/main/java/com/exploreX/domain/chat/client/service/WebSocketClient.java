package com.exploreX.domain.chat.client.service;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.ContainerProvider;

@ClientEndpoint
public class WebSocketClient {

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
        //TODO 将碎片交换

    }

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = new URI("ws://localhost:8080/websocket");

        try (Session session = container.connectToServer(WebSocketClient.class, uri)) {
            session.getBasicRemote().sendText("Hello, server!");
        }
    }
}
