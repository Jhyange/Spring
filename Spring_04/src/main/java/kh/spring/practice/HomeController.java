package kh.spring.practice;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

/**
 * Handles requests for the application home page.
 */
@Controller // handlermapper역할을 한다 
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MessageDAO mdao;
	
	@RequestMapping("/") //매서드가 url 하나씩 매핑 시킬 수 있다  
	public String index() {
		return "home"; //fowarding방식으로 페이지전환된다 , redirect라면 web-inf안에 못들어갔을거다 
	}
@RequestMapping("/inputForm")
public String toInputForm() {
	return "inputForm";
}
@RequestMapping("/inputProc")
public String inputProc(MessageDTO dto) {

	System.out.println(dto.getName()+":"+dto.getMsg());
	try {
		
		int result=mdao.Insert(dto);
	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return "home"; //입력이 잘 끝난 후 home으로 돌아갈 예정
}
@RequestMapping("/OutputForm")
public  String toOutputForm(HttpServletRequest request) {
	try {
		List<MessageDTO> list=mdao.select();
		request.setAttribute("list",list);
	return "OutputForm";
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
	
}



	
}
