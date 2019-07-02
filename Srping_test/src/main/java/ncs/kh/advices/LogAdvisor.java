package ncs.kh.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvisor {

/*@Pointcut("execution(* ncs.kh.dao.MembersDAO.*())")*/
@Pointcut("execution(* ncs.kh.controlelr.*.MembersDAO.*(..))")
public void printLog() {}

@Before("printLog()")

public void before(JoinPoint jp) {

Signature p = jp.getSignature();

String methodName = p.getName();

System.out.println(methodName);

}

}


/*@Component
@Aspect //spring관련 AOP이구나 , call하는 것이 아니라 알아서 자동으로 실행되는 매서드이다 

public class LogAdvices {
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	//return type package.. controller..method(매개변수)
	@Pointcut("execution(* kh.spring.aop.MemberController.*(..))")
	public void memberAll() {
		
	}
	@Pointcut("execution(* kh.spring.aop.HomeController.*(..))")
	public void homeAll() {
		
	}
@Before("execution(* *(..))")	
	@Before("execution(* kh.spring.aop.MemberController.*()) || execution(* kh.spring.aop.HomeController.*())")	
@Before("memberAll()")
	public void printLog(JoinPoint jp) { //advice
	//System.out.println(sdf.format(System.currentTimeMillis())+"/수행");
	//System.out.println(jp.getArgs()[0]); //우리가만든 advice함수가 가로채서 사용할 수 있다 
	
	System.out.println("전달된 인자값"+Arrays.toString(jp.getArgs()));
Signature sign= jp.getSignature();
StringBuilder sb=new StringBuilder();
sb.append(sdf.format(System.currentTimeMillis())+"에 ");
sb.append(sign.getName()+"매서드 실행");
System.out.println(sb.toString());
System.out.println(jp.getTarget()); //어떤 클레스가 실행되었는가 
System.out.println(sign.toLongString());//길게 매서드 얻을 수 있다 
}*/


/*}*/
