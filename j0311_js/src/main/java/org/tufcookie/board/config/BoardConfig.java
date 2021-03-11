package org.tufcookie.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

@Configuration
@Log4j
@MapperScan("org.tufcookie.board.mapper")
@ComponentScan("org.tufcookie.board.service")
public class BoardConfig {

}
