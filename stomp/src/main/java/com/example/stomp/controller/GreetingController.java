package com.example.stomp.controller;

import com.example.stomp.model.GreetingReq;
import com.example.stomp.model.GreetingResp;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * Created by ycwu on 2018/4/23.
 */
@Controller
public class GreetingController {

    @MessageMapping("/greeting")
    @SendToUser("/queue/greeting")
    public GreetingResp greeting(GreetingReq req) {
        return new GreetingResp(req == null ? "UNKNOWN" : req.getName());
    }
}
