package kh.spring.practice;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kh.spring.dto.MessageDTO;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "home"; 
	}
	
/*	@ResponseBody
	@RequestMapping("/ajax.do")
	public String ajaxProc() {
		List<MessageDTO> arr = new ArrayList<>();
		arr.add(new MessageDTO(1,"Jane1","hello1"));
		arr.add(new MessageDTO(2,"Jane2","hello2"));
		arr.add(new MessageDTO(3,"Jane3","hello3"));
		arr.add(new MessageDTO(4,"Jane4","hello4"));
		
		//Integer.parseInt("abc");
		
		return new Gson().toJson(arr); //return 값을 dto로 보낼 수 없으므로 string형을 만들어야한다 
	}*/
	
	
	@ResponseBody
	@RequestMapping("asJson")

	public String inputProc(String data1, String data2) {
		 
	JsonObject obj = new JsonObject();
   
	obj.addProperty("data1", data1);

	obj.addProperty("data2", data2);

	return new Gson().toJson(obj);

	}
	
	

/*	
	@RequestMapping(value="input",method=RequestMethod.GET)

	public String inputProc1(String name, String message) {

	System.out.println(name + " : " + message);

	return "home";

	}
	
	@Autowired

	private MyUtil util;


	@RequestMapping("process")

	public String inputProc() {

	util.testingFunc();

	return "home";

	}*/
	
}
