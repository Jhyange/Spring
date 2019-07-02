package kh.spring.aspect;



import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //spring관련 AOP이구나 , call하는 것이 아니라 알아서 자동으로 실행되는 매서드이다 

public class LogAdvices {
@Pointcut("execution(* kh.spring.aop.MemberController.*(..))")

public void perfCheck() {}

@Around("perfCheck()")

public Object performance(ProceedingJoinPoint jp) {

long startTime = System.currentTimeMillis();

Object returnObj = null;

try {

returnObj = jp.proceed();

} catch (Throwable e) {

e.printStackTrace();

}

long endTime = System.currentTimeMillis();

System.out.println(endTime - startTime);
return  returnObj;
}



}
















