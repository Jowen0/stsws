package org.tufcookie.time.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

@ComponentScan("org.tufcookie.time.service")
@MapperScan(basePackages = "org.tufcookie.time.mapper")
@Configuration
@Log4j
public class TimeConfig {

}
