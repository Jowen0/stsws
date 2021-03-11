package org.tufcookie.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tufcookie.board.config.BoardConfig;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {CommonConfig.class, BoardConfig.class})
@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
	PageDTO dto = new PageDTO();
	
	@Test
	public void testGetList() {
		
		dto.setType("t");
		dto.setKeyword("10");
		
		mapper.getList(dto.getSkip(),
					   dto.getPerSheet(),
					   dto.getArr(),
					   dto.getKeyword())
		.forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testGetTotal() {
		
		dto.setType("t");
		dto.setKeyword("10");
		
		log.info(mapper.getTotalCount(dto.getArr(), dto.getKeyword())); 
		
	}

}
