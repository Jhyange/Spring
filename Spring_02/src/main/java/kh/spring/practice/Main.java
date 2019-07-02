package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.interfaces.Tv;

public class Main {
public static void main(String[] args) {
	AbstractApplicationContext ctx=new GenericXmlApplicationContext("context.xml");
	Tv tv=(Tv)ctx.getBean("sam");
	tv.PowerOn();
}
}
