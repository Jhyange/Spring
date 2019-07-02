package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.MessageDAO;

@Service("Service")
public class Servicetx {
	@Autowired
	private MessageDAO dao;
   @Transactional
   public boolean tranasction() {
	  
	   dao.insert();
	   dao.update();
	   return true;
   }
}
