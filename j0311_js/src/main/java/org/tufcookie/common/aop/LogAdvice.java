package org.tufcookie.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	@Before(value = "execution(* org.tufcookie..*.*Service*.*(..))") //이 부분은 절대 손으로 치지않고, 복사한다.
	public void logBefore() {
		
		log.info("=============================");
		
		 
	}
	
	@Before(value = "execution(* org.tufcookie..*.*Controller*.*(..))") //이 부분은 절대 손으로 치지않고, 복사한다.
	public void logBeforeController(JoinPoint jp) {
		
		log.info("=============================");
		//jp.getSignature() - 메서드
		String methodName = jp.getSignature().getName();
		 
		Object[] args = jp.getArgs();
		
		log.info(methodName);
		log.info(Arrays.toString(args));
		
	}
	
	//300ms가 초과하면 경고
	@Around(value = "execution(* org.tufcookie..*.*Service*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp){
		
		String methodName = pjp.getSignature().getName();
		
		log.info(pjp.getSignature()); // 실행 클래스? 메서드? 확인
		log.info(methodName + ":::::::" + Arrays.toString(pjp.getArgs())); //메서드 이름 & 파라미터 배열 확인
		//log.info(Arrays.toString(pjp.getArgs())); //파라미터 배열 확인
		log.info(pjp.getThis());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		try {
			
			result = pjp.proceed();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("end-----------------------");
		
		long end = System.currentTimeMillis();
		
		log.info("time: " + (end - start));
		
		return result;
		
	}
	
	
}
