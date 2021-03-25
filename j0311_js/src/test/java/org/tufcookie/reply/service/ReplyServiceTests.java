package org.tufcookie.reply.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.reply.config.ReplyConfig;
import org.tufcookie.reply.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, ReplyConfig.class})
@Log4j
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void testInsertDummies() {
		
		int bno = 261;
		
		for(int i = 0; i < 15; i++) {
			
			ReplyVO vo = ReplyVO.builder()
					.reply("test..." + i)
					.replyer("user..." + i)
					.bno(bno)
					.build();
			
			service.register(vo);
		}
	}
	
	@Test
	public void testSelectOne() {
		
		ReplyVO vo = service.readOne(10);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() { 
		
		service.remove(1);
		
		log.info(1);
	}
	
	@Test
	public void testUpdate() {
		
		ReplyVO vo = ReplyVO.builder()
				.rno(15)
				.reply("updatetest...")
				.replyer("user...")
				.build();
		
		service.modify(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testList( ) { 
		
		service.getList(261, 0).forEach(reply -> log.info(reply));
		
	}

}
