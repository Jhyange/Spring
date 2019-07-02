package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{ //controller를 이용

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WEB-INF/index.jsp");//보낼 위치, fowarding방식으로 동작하여 문제 없이 간다  
		
		
		return mav;
	} //요청을 handle함 , doget이랑 dopost의 역할을 한다  , dispatcher에게 보냄

}
