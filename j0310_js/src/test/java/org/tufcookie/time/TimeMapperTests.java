package org.tufcookie.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.time.config.TimeConfig;
import org.tufcookie.time.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, TimeConfig.class})
@Log4j
public class TimeMapperTests {
	
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		
		log.info(timeMapper.getTime());
		
	}

}
