package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{ //controller�� �̿�

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WEB-INF/index.jsp");//���� ��ġ, fowarding������� �����Ͽ� ���� ���� ����  
		
		
		return mav;
	} //��û�� handle�� , doget�̶� dopost�� ������ �Ѵ�  , dispatcher���� ����

}
