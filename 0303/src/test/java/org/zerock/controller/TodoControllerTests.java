package org.zerock.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j;

@Log4j
public class TodoControllerTests extends AbstractControllerTests{
	
	//단점: 상속을 받아도 log를 못 쓴다. 때문에 다시 선언해줘야 한다.
	@Test
	public void test1() throws Exception{
		
		log.info(mockMvc);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/todo/add")
				.param("title", "Sample....")
				.param("complete", "true"));
		
	}
	
}
