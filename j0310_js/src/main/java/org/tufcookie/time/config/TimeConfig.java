package org.tufcookie.time.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

@Configuration
@MapperScan(basePackages = "org.tufcookie.time.mapper")
@ComponentScan(basePackages = "org.tufcookie.time.service")
@Log4j
public class TimeConfig {

	
	
}
