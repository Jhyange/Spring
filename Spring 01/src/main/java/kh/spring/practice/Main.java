package kh.spring.practice;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.Fruits;
import kh.spring.interfaces.Tv;

public class Main {
	public static void main(String[] args) {
	AbstractApplicationContext ctx=new GenericXmlApplicationContext("context.xml");  //명령대기중
	//ctx.getBean("sam");
	//bean을 가져오는 경우 , 자료형으로 클레스를 만들어 두웠지만 이름이 없어서 가져올 방법이 없다 -> id값을 부여하여 
	//id값이 sam인 인스턴스를 가져오게 된다 
	//object타입으로 리턴 시키므로 casting하여 사용하여야 한다 
	//ctx.getBean(SamsungTv.class);
	
	//SamsungTv tv=ctx.getBean(SamsungTv.class);
	//tv.powerOn();
	
	Tv tv1 =ctx.getBean(Tv.class);
	tv1.powerOn();
	tv1 =ctx.getBean(Tv.class);
	tv1.powerOn();
	tv1 =ctx.getBean(Tv.class);
	

	
	}
}
