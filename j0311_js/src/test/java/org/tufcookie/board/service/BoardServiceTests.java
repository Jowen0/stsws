package org.tufcookie.board.service;

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
public class BoardServiceTests {
	
	@Autowired
	BoardService service;
	
	PageDTO pageDTO = new PageDTO();
	
	@Test
	public void testGetListPage() {
		
		pageDTO.setType("t");
		pageDTO.setKeyword("10");
		
		service.getListPage(pageDTO).forEach(dto -> log.info(dto));
		
	}
	
	@Test
	public void testGetTotalCount() {
		
		pageDTO.setType("t");
		pageDTO.setKeyword("10");
		
		log.info(service.getTotal(pageDTO));
		
	}

}
