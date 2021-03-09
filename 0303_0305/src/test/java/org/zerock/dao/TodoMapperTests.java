package org.zerock.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.entity.Todo;
import org.zerock.mapper.TodoMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	
	@Autowired
	TodoMapper mapper;
	
	@Test
	public void testInsert() {
		
		IntStream.rangeClosed(1, 100) //i는 1부터 100까지
		.forEach(i -> {
			Todo todo = Todo.builder().title("t"+i).build();
			mapper.insert(todo);
		});
		
	}
	
}
