package kh.spring.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;
@Component("lg")
public class LgTv implements Tv {
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
public LgTv() {
	System.out.println("lg»ý¼ºÀÚ");
};
	@Override
	public void PowerOn() {
		
		System.out.println("Lg Tv on");
	}

}
