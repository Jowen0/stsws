package org.tufcookie.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.log4j.Log4j;

@Configuration
@MapperScan("org.tufcookie.board.mapper")
@ComponentScan("org.tufcookie.board.service")
//aop 추가
@ComponentScan(basePackages = {"org.tufcookie.common.aop"})
@EnableAspectJAutoProxy
public class BoardConfig {

}
