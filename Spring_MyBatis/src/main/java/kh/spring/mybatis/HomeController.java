package kh.spring.mybatis;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.TempDTO;
import kh.spring.service.Servicetx;


@Controller
public class HomeController {
@Autowired
private MessageDAO dao;
@Autowired
private Servicetx serive;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "home";
	}
	@RequestMapping("insert")
/*	@Transactional*/
	public String insert() {
		
		/*dao.insert();
		dao.update();*/
		boolean saved=false;
		try {
			saved=serive.tranasction();
		}catch(Exception ex) {
			saved=false;
			ex.printStackTrace();
		}
		
		System.out.println(saved);
		return "home";
	}
	@RequestMapping("select")
	public String select() {
		/*List<MessageDTO> list=dao.selectAll();
		for(MessageDTO tmp: list)
		{
			System.out.println(tmp.getSeq()+tmp.getName()+tmp.getMessage());
		}*/
		
		TempDTO dto=dao.selectByseq();
		System.out.println(dto.getId()+ dto.getNum()+ dto.getContents());
		return "home";
	}
	@RequestMapping("update")
	public String update() {
		
		dao.update();
		return "home";
	}
	@RequestMapping("delete")
	public String delete() {
		dao.delete();             
		return "home";
	}
	
}
