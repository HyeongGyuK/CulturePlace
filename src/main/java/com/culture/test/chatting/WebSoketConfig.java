package com.culture.test.chatting;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSoketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 클라이언트로 메세지를 응답해줄때 prefix 정의 - 클라이언트가 메세지를 받을 때
		registry.enableSimpleBroker("/sub");
		
		// 클라이언트에서 메세지 송신시 붙일 prefix 정의 - 클라이언트가 메세지를 보낼 때
		registry.setApplicationDestinationPrefixes("/pub");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/stomp/chat")
		.setAllowedOrigins("*")
		.withSockJS();
	}

}
