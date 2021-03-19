package org.zerock.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SecurityTests {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	
	@Test
	public void test1() {
		
		log.info(pwEncoder);
		
	}
	
	@Test
	public void testMember() { //$2a$10$JSYlIvOhK8Dl9tN1aHbii.5xJzxCW6hKG4yyY/hiB78oGdFEQIafm
							   //$2a$10$5QCstKnRYZVCO/Xl.fpqruQ89KLwJ2vcDfBSEBj19kSXRTCWqB/LC
		
		String pw = "member";
		
		String enPw = pwEncoder.encode(pw);
		
		log.info(enPw);
		
	}
	
	@Test
	public void testMatch() {
		
		String secret = "$2a$10$JSYlIvOhK8Dl9tN1aHbii.5xJzxCW6hKG4yyY/hiB78oGdFEQIafm";
		
		boolean result = pwEncoder.matches("member", secret); //사용자가 입력할 값, DB에 있는 값
		
		log.info(result);
		
	}
}
