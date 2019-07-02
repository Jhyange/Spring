package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
@Component("sony")
public class SonySpeaker implements Speaker{

	@Override
	public void VolumUP() {
		// TODO Auto-generated method stub
		System.out.println("¼Ò´Ï º¼·ý ¾÷");
	}

}
