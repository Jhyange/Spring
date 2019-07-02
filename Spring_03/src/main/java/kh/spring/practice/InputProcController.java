package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

public class InputProcController implements Controller{
	@Autowired
	private MessageDAO mdao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();	
		String name=request.getParameter("name");
		String msg=request.getParameter("msg");
		try {
		int result=mdao.Insert(new MessageDTO(0,name,msg));
		}catch(Exception e)
		{
			mav.setViewName("redirect:error.do");
			e.printStackTrace();
		}
		System.out.println("이름"+name+"메시지"+msg);
		mav.setViewName("redirect:/"); 
		return mav;
	}
}
