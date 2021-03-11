package org.tufcookie.time.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.tufcookie.common.controller.AbstractControllerTests;
import org.tufcookie.time.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;


@Log4j
public class TimeControllerTests extends AbstractControllerTests{
	
	@Test
	public void testGetTime() throws Exception {  
		
		mockMvc.perform(MockMvcRequestBuilders.get("/time/now"))
		.andExpect(status().isOk())
		.andDo(print());
		
	}
	
}
