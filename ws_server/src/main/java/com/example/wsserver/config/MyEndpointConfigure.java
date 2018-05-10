package com.example.wsserver.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpointConfig;

/**
 * Created by ycwu on 2018/4/12.
 */
@Component
public class MyEndpointConfigure extends ServerEndpointConfig.Configurator implements ApplicationContextAware
{
    private static volatile BeanFactory context;

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException
    {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        MyEndpointConfigure.context = applicationContext;
    }
}