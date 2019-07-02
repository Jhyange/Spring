package kh.spring.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import kh.spring.dto.MessageDTO;

@Controller
public class ChatController {

	
	//messagemapping으로 들어온 작업을 매소드를 통하여 작업 한 후 sendto()로 보내라 !
	@MessageMapping("/chat")
	@SendTo("/response")
	//웹소켓을 onmessage어노테이션을 사용하는 부분과 동일하다 
	//response , 즉 구독하고 있는 클라이언트에게만 보낸다 
	public MessageDTO messageProc(StompHeaderAccessor sha,MessageDTO dto) {
		//클라이언트가 웹 소켓을 통하여 prefix/chat으로 보내야 messageMapping이 가능하다 
		//app/ chat을 사용한다
		//jackson은 바로 parsing할 수 있다 
		/*dto.setName("jack");*/
		System.out.println(sha.getSessionAttributes().get("id"));
		//autowired session으로 출력을 할 수 없다 
        dto.setName((String) sha.getSessionAttributes().get("id"));
	   System.out.println(dto.getMessage()); 
		return dto; //jackson을 사용함으로써 dto를 보낼 수 있다 
	}


}
