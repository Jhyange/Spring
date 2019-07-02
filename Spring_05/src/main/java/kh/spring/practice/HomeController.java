package kh.spring.practice;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.dao.MessageDAO1;
import kh.spring.dao.MessageDAO2;
import kh.spring.dto.MessageDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
/*	@Autowired
	private MessageDAO1 dao;*/
	@Autowired
	private MessageDAO2 dao2;
	
@RequestMapping("/")
public String index() {
	
	return "home";
}
@RequestMapping("/inputform")
	public String inputform() {
	return "inputform";
}
@RequestMapping("/inputproc")
public String inputproc(String name,String msg) {
	System.out.printf("이름"+name+"메시지"+ msg);
	try {
		//dao.Insert(new MessageDTO(0,name,msg));
		System.out.println("입력성공");
		dao2.insert(new MessageDTO(0,name,msg));
	}catch(Exception e)
	{e.printStackTrace();
	}
	
	return "redirect:/";
}

@RequestMapping("/outputform")
public String outputform(HttpServletRequest request) {
	try {
	List<MessageDTO> list=dao2.selectAll();
	System.out.println(list);
	request.setAttribute("list", list);
return "outputform";
}catch(Exception e)
{
	e.printStackTrace();
}
return null;

	}
	

}