package kh.spring.socket;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		session.setAttribute("data", "data");		
		return "home";
	}
	@RequestMapping("webchat")
	public String webChat() {
	
		return "webchat";
	}
	/*@RequestMapping("hi")
	public String hi() {
	//	session.getAttribute("ff");
		session.setAttribute("list", "hyang");
		return "webchat";
	}*/
}
