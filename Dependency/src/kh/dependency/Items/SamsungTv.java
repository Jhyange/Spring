package kh.dependency.Items;

import kh.dependency.interfaces.Tv;

public class SamsungTv implements Tv{
private String model;
private int price;
private boolean power;

public void powerOn() {
	this.power=true;

}
public void powerOff() {
	this.power = false;
}

public SamsungTv(String model, int price, boolean power) {
	super();
	this.model = model;
	this.price = price;
	this.power = power;
}
public SamsungTv() {
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
public void poweron() {
	// TODO Auto-generated method stub
	
}
@Override
public void poweroff() {
	// TODO Auto-generated method stub
	
}
}
