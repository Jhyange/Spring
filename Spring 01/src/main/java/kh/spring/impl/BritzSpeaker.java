package kh.spring.impl;

import kh.spring.interfaces.Speaker;

public class BritzSpeaker implements Speaker{
public void volumeUp() {
	
	System.out.println("브리치 스피커 : 볼륨업");
}

@Override
public void powerOn() {
	// TODO Auto-generated method stub
	
}
}
