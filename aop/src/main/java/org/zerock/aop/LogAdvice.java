package org.zerock.aop;

import java.util.Arrays;

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
	
	//controller에 추가하려면 servelt-config에 aop가 걸려야 하고, 아래에 autoproxy를 걸어야 한다.
	
	@Before(value = "execution(* org.zerock..*.*.*(..))") //이 부분은 절대 손으로 치지않고, 복사한다.
	public void logBefore() {
		
		log.info("=============================");
		
		 
	}
	
	//300ms가 초과하면 경고
	//@Around(value = "execution(* org.zerock..*.*Service*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable{
													//트랜잭션 & AOP를 같이 사용하려면 throws Throwable 필요
		
		String methodName = pjp.getSignature().getName();
		
		log.info(pjp.getSignature()); // 실행 클래스? 메서드? 확인
		log.info(methodName + ":::::::" + Arrays.toString(pjp.getArgs())); //메서드 이름 & 파라미터 배열 확인
		//log.info(Arrays.toString(pjp.getArgs())); //파라미터 배열 확인
		log.info(pjp.getThis());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		Object error = null; //트랜잭션 & AOP를 같이 사용하려면 error를 던져야 하는데 그전에 error 선언
		
		try {
			
			result = pjp.proceed();
			
		} catch (Throwable e) {
			
			log.error(e.getMessage());
			error = e;
			
		}
		
		log.info("end-----------------------");
		
		long end = System.currentTimeMillis();
		log.info(methodName + "  time: " + (end - start));
		
		//트랜잭션 & AOP 같이 하려면 에러를 던져야 한다.
		if(error != null) {
			
			throw (Throwable) error;
			
		}
		
		
		return result;
		
	}
	
	
}
