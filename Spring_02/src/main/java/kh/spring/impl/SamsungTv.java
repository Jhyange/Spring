package kh.spring.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("sam")

public class SamsungTv implements Tv {
/*	@Autowired
	@Qualifier("sony")*/
	@Resource(name="britz")
	private Speaker speaker;
	
	
	public SamsungTv() {
		System.out.println("»ï¼ºÆ¼ºñ »ý¼ºµÊ");
	}
	@Override
	public void PowerOn() {
		System.out.println("samsung Tv on ");
		speaker.VolumUP();
	}

}
