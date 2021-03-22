package org.tufcookie.reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.reply.config.ReplyConfig;
import org.tufcookie.reply.domain.ReplyVO;
import org.tufcookie.reply.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, ReplyConfig.class})
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testInsertDummies() {
		
		int bno = 262;
		
		for(int i = 0; i < 15; i++) {
			
			ReplyVO vo = ReplyVO.builder()
					.reply("test..." + i)
					.replyer("user..." + i)
					.bno(bno)
					.build();
			
			mapper.insert(vo);
		}
	}
	
	@Test
	public void testSelectOne() {
		
		ReplyVO vo = mapper.selectOne(10);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		
		mapper.delete(1);
		
		log.info(1);
	}
	
	@Test
	public void testUpdate() {
		
		ReplyVO vo = ReplyVO.builder()
				.rno(15)
				.reply("updatetest...")
				.replyer("user...")
				.build();
		
		mapper.update(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testList( ) { 
		
		mapper.selectList(262, 0).forEach(reply -> log.info(reply));
		
	}
	
}
