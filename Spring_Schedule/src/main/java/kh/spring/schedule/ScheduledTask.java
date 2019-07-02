package kh.spring.schedule;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	
	/*private SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	@Scheduled(cron="50 40 * * * *")
	public void  task1() {
	
		//초 분 시 일 월 요일 연도 
		System.out.println(sdf.format(System.currentTimeMillis())+"출력확인");
	}//schedule은 return은 무조건 void / 인자값은 받을 수 없다 

	
	@Scheduled(cron="0/5 52 9,10 * * *")
	public void  task2() {
	
		//초 분 시 일 월 요일 연도 
		System.out.println(sdf.format(System.currentTimeMillis())+"출력확인");
	}//schedule은 return은 무조건 void / 인자값은 받을 수
	
	@Scheduled(cron="0 0 0 * * *")
	public void everyMidNight() {

	}*/
	
	
		

		

		@Scheduled(fixedRate=1000)

		public void scheduleTask() {

		System.out.println("Hello Schedule");

		}

		
		
	
}
