package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.service.Restaurant;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class InjectTests {
	
	//의존성 주입
	//생성자 주입 / setter 주입 / 필드 주입
	//3. 필드 주입
	
	@Autowired //가장 간단하게 테스트 하는 방법
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		log.info(restaurant);
	}

}
