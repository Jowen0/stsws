package org.tufcookie.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.tufcookie.common.AbstractControllerTests;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardControllerTests extends AbstractControllerTests{
	
	@Test
	public void test1() throws Exception{
		
		log.info(mockMvc);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andExpect(status().isOk())
		.andDo(print( ));
		
	}

}
