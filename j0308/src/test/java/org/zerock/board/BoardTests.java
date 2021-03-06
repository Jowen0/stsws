package org.zerock.board;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.config.BoardConfig;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.service.BoardService;
import org.zerock.common.config.CommonConfig;
import org.zerock.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, BoardConfig.class})
@Log4j
public class BoardTests {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	BoardService service;
	
//	@Test
//	public void testEx1() {
//		
//		PageDTO dto = new PageDTO();
//		
//		boardMapper.ex1(dto).forEach(board -> log.info(board));
//		
//	}
//	
//	
//	@Test
//	public void testList2( ) {
//		
//		boardMapper.getList(0, 10)
//		.forEach(vo -> log.info(vo));
//		
//	}
	
	
	@Test
	public void testList() {
		
		//boardMapper.getList(10,10).forEach(board -> log.info(board));
		
		service.getPageList(PageDTO.builder()
				.page(1)
				.type("tcw")
				.keyword("10")
				.build())
		.forEach(dto -> log.info(dto));
		
		//밖에서는 인터페이스 쓰는 것과 람다 쓰는 것을 싫어한다.
		//건방지다고 욕만 얻어 먹는다.
		
	}

}
