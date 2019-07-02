package kh.spring.aop;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
@RequestMapping("login")	
public String login(String id) {
	
	
	return "home";
	
}
@RequestMapping("logout")	
public String logout() {
	

	return "home";
	
}
@RequestMapping("mypage")	
public String mypage() {
	
	
	return "home";
	
}
}
