package kh.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfCheckAdvice {
	@Around("execution(* kh.spring.aop.MemberController.*(..))")
	public Object perfCheck(ProceedingJoinPoint pjp) { //반드시 object일 필요는 없지만 pjp.proceed는 object형으로 받아야하므로 object를 리턴한다 
		//자신이 weaving되는 pointcut매서드의 영향을 줄 수 있다  , 변화를 줄 수 있고 실행을 안할 수 있는등 여러가지의 액션이 가능하다 
		//before는 실행되기전에 하고싶은 일이 있으면 자신홀로하면 끝 
		long startTime=System.currentTimeMillis();
		Object retVal=null;
		try {
			retVal=pjp.proceed();//가로챔
		} catch (Throwable e) {
			
			e.printStackTrace();
		} // 우리가 직접 pointcut 실행 시점을 정할 수 있다 , 이 시점 이전=before / 이시점이후=after
		long endTime=System.currentTimeMillis();
		System.out.println((endTime-startTime)/1000.0+"초간 수행 ");
		return retVal;
	}
}
