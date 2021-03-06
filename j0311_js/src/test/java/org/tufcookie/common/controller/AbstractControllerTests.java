package org.tufcookie.common.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.tufcookie.board.config.BoardConfig;
import org.tufcookie.common.config.CommonConfig;
import org.tufcookie.common.config.ServletConfig;
import org.tufcookie.time.config.TimeConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class,
								TimeConfig.class,
								BoardConfig.class,
								ServletConfig.class})
@Log4j
@WebAppConfiguration
public class AbstractControllerTests {
	
	@Autowired
	protected WebApplicationContext ctx;
	protected MockMvc mockMvc;
	
	@Before
	public void setup( ) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("setup............");
	}
	
}
