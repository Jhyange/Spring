package kh.spring.practice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;

public class OutProcController<MessageDTO> implements Controller {
	@Autowired
	private MessageDAO mdao;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		try {
			List<MessageDTO> list=mdao.select();
			mav.addObject("list",list);
			mav.setViewName("WEB-INF/output/output.jsp");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mav;
	}

}
