package com.example.wsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class WsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsServerApplication.class, args);
	}
}
