//package com.exploreX.domain.chat.client.service;
//
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.java_websocket.client.WebSocketClient;
//import org.java_websocket.handshake.ServerHandshake;
//
//import java.net.URI;
//import java.util.concurrent.atomic.AtomicBoolean;
//
///**
// * 自定义WebSocket客户端
// */
//@Slf4j
//public class CustomizedWebSocketClient extends WebSocketClient {
//    private static final Logger logger = LoggerFactory.getLogger(CustomizedWebSocketClient.class);
//
//    //用来接收数据
//    private String excptMessage;
//
//    /**
//     * 线程安全的Boolean -是否受到消息
//     */
//    public AtomicBoolean hasMessage = new AtomicBoolean(false);
//
//    /**
//     * 线程安全的Boolean -是否已经连接
//     */
//    private AtomicBoolean hasConnection = new AtomicBoolean(false);
//
//    /**
//     * 构造方法
//     *
//     * @param serverUri
//     */
//    public CustomizedWebSocketClient(URI serverUri) {
//        super(serverUri);
//        log.info("CustomizeWebSocketClient init:" + serverUri.toString());
//    }
//
//    /**
//     * 打开连接是方法
//     *
//     * @param serverHandshake
//     */
//    @Override
//    public void onOpen(ServerHandshake serverHandshake) {
//        log.info("CustomizeWebSocketClient onOpen");
//    }
//
//    /**
//     * 收到消息时
//     *
//     * @param s
//     */
//    @Override
//    public void onMessage(String s) {
//        hasMessage.set(true);
//        log.info("CustomizeWebSocketClient onMessage:" + s);
//    }
//
//    public void sendMessage(String message){
//        this.send(message);
//        log.info("已发送消息：" + message);
//    }
//
//    /**
//     * 当连接关闭时
//     *
//     * @param i
//     * @param s
//     * @param b
//     */
//    @Override
//    public void onClose(int i, String s, boolean b) {
//        this.hasConnection.set(false);
//        this.hasMessage.set(false);
//        log .info("CustomizeWebSocketClient onClose:" + s);
//    }
//
//    /**
//     * 发生error时
//     *
//     * @param e
//     */
//    @Override
//    public void onError(Exception e) {
//        logger.error("CustomizeWebSocketClient onError:" + e);
//    }
//
//    @Override
//    public void connect() {
//        if(!this.hasConnection.get()){
//            super.connect();
//            hasConnection.set(true);
//        }
//    }
//
//    //获取接收到的信息
//    public String getExcptMessage() {
//        if(excptMessage != null){
//            String message = new String(excptMessage);
//            excptMessage = null;
//            return message;
//        }
//        return null;
//    }
//}
//
//