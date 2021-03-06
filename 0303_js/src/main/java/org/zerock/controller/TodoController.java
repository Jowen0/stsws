package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.Todo;
import org.zerock.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
@RequestMapping("/todo/*")
public class TodoController {
	
	private final TodoMapper todoMapper;
	
public String addPost(Todo todo) {
		
		todoMapper.insert(todo);
		
		return "redirect:/todo/list";
	}
	
}
