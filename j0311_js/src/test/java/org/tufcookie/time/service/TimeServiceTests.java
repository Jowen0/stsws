package org.tufcookie.time.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.time.config.TimeConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, TimeConfig.class})
@Log4j
public class TimeServiceTests {
	
	@Autowired
	TimeService service;
	
	@Test
	public void testGetTime() {
		
		log.info(service.getTime());
		
	}
	
	@Test
	public void testGetTime2() {
		
		log.info(service.getTime2());
		
	}

}
