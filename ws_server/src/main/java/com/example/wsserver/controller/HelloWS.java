package com.example.wsserver.controller;

import com.example.wsserver.config.MyEndpointConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by ycwu on 2018/4/10.
 */
@Component
@ServerEndpoint(value = "/ws/hello", configurator = MyEndpointConfigure.class)
public class HelloWS {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public HelloWS() {
        logger.info("create HelloWS instance");
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        logger.info("# onOpen: session={}", session.getId());
        try {
            session.getBasicRemote().sendText("hello");
        } catch (IOException e) {
            logger.error("onOpen error: ", e);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("# onClose: session={}, reseaon={}", session.getId(), closeReason.toString());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.error("# onError: session={}, ", session.getId(), throwable);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("# onMessage: {}", message);
    }

}
