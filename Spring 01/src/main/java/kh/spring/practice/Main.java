package kh.spring.practice;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.Fruits;
import kh.spring.interfaces.Tv;

public class Main {
	public static void main(String[] args) {
	AbstractApplicationContext ctx=new GenericXmlApplicationContext("context.xml");  //��ɴ����
	//ctx.getBean("sam");
	//bean�� �������� ��� , �ڷ������� Ŭ������ ����� �ο����� �̸��� ��� ������ ����� ���� -> id���� �ο��Ͽ� 
	//id���� sam�� �ν��Ͻ��� �������� �ȴ� 
	//objectŸ������ ���� ��Ű�Ƿ� casting�Ͽ� ����Ͽ��� �Ѵ� 
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
