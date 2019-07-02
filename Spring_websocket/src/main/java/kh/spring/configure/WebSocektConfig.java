package kh.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration //설정을 위해서 존재하는 역할의 bean으로 만들어진다 
@EnableWebSocketMessageBroker
public class WebSocektConfig implements WebSocketMessageBrokerConfigurer{
	//spring은 pojo를 추구하는데 implements를  사용한다는 의문점 발생
	// WebSocketMessageBrokerConfigurer : 웹 소켓의 메세지를 설정하는 자 , 웹소켓의 클라이언트와의 중계 역할로서 설정자 역할을 한다 

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		registry.setApplicationDestinationPrefixes("/app");
		//client가 endpoint를 이용하여 연결한 후 메시지를 보내는 url을 이용하여 메시지를 보내다 
		//그때 만들어지는 url의 앞의 url은 prefixes이다
		//없어도 통신은 가능하지만 일반 url과 동일한 url로 접근이 되므로 prefix를 사용하여 구분짓는다 
		registry.enableSimpleBroker("/response");
		//클라이언트가 서버의 응답메시지를 받을 url이다 
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
		StompWebSocketEndpointRegistration swer =registry.addEndpoint("/webchat"); 
		//endpoint: 웹소켓이 접근할 서버측의 끝 url 
		//일반 websocket과 달리 url패턴을 설정할 수 있다
		//swer변수를 이용하여 session정보를 공유하는 경우 사용한다 (=session 동기화)
		swer.addInterceptors(new HttpSessionHandshakeInterceptor());
		//클라이언트의 요청마다 session정보를 저장할 수 있다 
		swer.setAllowedOrigins("*");//cross origin issue를 꺼버린다
		swer.withSockJS();

	}

}
