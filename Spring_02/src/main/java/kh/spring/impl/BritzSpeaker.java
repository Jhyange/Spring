package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
@Component("britz")
public class BritzSpeaker  implements Speaker{

	@Override
	public void VolumUP() {
		// TODO Auto-generated method stub
	System.out.println("britzº¼·ý¾÷");
	}

}
