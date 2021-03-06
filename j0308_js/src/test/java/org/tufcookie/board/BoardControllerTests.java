package org.tufcookie.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.tufcookie.common.AbstractControllerTests;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardControllerTests extends AbstractControllerTests{
	
	@Test
	public void test1() throws Exception{
		
		log.info(mockMvc);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andDo(print( ));
		
	}

}
