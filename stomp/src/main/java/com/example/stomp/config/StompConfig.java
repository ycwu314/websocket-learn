package com.example.stomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by ycwu on 2018/4/23.
 */
@Configuration
public class StompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * endpoint是注册stomp协议的断点。先访问这个url来升级到stomp协议
     *
     * 如果前端使用websocket直接连接，则不要开启withSockJS()。
     *
     * 如果前端使用SockJS连接，则url为http(s)开头。
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 使用内置的in-memory代理。
        registry.enableSimpleBroker("/topic", "/queue");
        // 转发请求到外部的broker。
        //registry.enableStompBrokerRelay("");

        // 发送指定用户的前缀。
        // 客户端调用要带有该前缀。
        // 服务器端的@SendTo，@SendToUser不要带有该前缀。
        registry.setUserDestinationPrefix("/user");

        // 对于该前缀，转去使用@MessageMapping注解的方法去处理。
        // 客户端调用的url带有该前缀。
        // @MessageMappin的url不需要带有该前缀。框架自动从请求url去掉该前缀再去匹配@MessageMappin的url映射。
        registry.setApplicationDestinationPrefixes("/app");
    }
}
