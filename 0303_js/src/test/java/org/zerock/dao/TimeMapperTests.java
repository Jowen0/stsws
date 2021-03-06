package org.zerock.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	public void testTime2() {
		
		log.info(sqlSessionFactory);
		
		log.info(timeMapper.getTime2());
		
	}
	
	
//	@Test
//	public void testTime() {
//		
//		log.info(timeMapper);
//		
//		log.info(timeMapper.getTime());
//		
//	}
	
}
