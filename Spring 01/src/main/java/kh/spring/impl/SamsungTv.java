package kh.spring.impl;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

public class SamsungTv implements Tv {
private Speaker speaker; //=new SonySpeaker();--> 이작업을 context.xml이 대신함 	
private String model;
private int price;
private boolean power;



public SamsungTv() {
	
}

public SamsungTv(Speaker speaker, String model, int price, boolean power) {
	this.speaker = speaker;
	this.model = model;
	this.price = price;
	this.power = power;
}

public Speaker getSpeaker() {
	return speaker;
}

public void setSpeaker(Speaker speaker) {
	this.speaker = speaker;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public boolean isPower() {
	return power;
}

public void setPower(boolean power) {
	this.power = power;
}

@Override
public void powerOn() {
	// TODO Auto-generated method stub

	System.out.println("삼성 Tv ON"+this);
}


}
