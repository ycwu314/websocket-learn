package com.example.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableWebSocketMessageBroker
public class StompApplication {

	public static void main(String[] args) {
		SpringApplication.run(StompApplication.class, args);
	}
}
