package org.tufcookie.reply.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.tufcookie.reply.mapper")
@ComponentScan("org.tufcookie.reply.service")
public class ReplyConfig {

}
