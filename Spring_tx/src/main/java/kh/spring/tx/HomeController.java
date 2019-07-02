package kh.spring.tx;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.service.BuyService;
import spring.kh.dto.PayDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BuyService bservice;
	
	@Autowired
	private HttpSession session;
	

	@RequestMapping("/")
	public String index() {
		return "home"; 
	}

	@RequestMapping("buy.do")
	public String but(PayDTO dto){
		try {
			bservice.Buy(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
