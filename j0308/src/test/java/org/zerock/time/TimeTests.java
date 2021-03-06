package org.zerock.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.common.config.CommonConfig;
import org.zerock.time.config.TimeConfig;
import org.zerock.time.mapper.TimeMapper;
import org.zerock.time.service.TimeService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, TimeConfig.class})
@Log4j
public class TimeTests {
	
	@Autowired
	TimeService timeService;
	
	@Autowired
	TimeMapper timeMapper;
	
	
	@Test
	public void testService() {
		
		log.info(timeService.getTime());
		
	}
	
	@Test
	public void testExist() {
		
		log.info("=======================================");
		log.info(timeMapper); //timeMapper 존재 여부 확인 - MapperProxy
		log.info(timeMapper.getNow()); //timeMapper 작동 확인 - 현재 시간
		
		log.info(timeMapper.getNow2());
		
	}
	
}
