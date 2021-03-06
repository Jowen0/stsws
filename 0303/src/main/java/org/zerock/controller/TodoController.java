package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.dto.TodoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*") //안전하게 ("/todo/*")선언 //요즘 트랜드 - 43분
@Log4j
@RequiredArgsConstructor
public class TodoController {
	
	@GetMapping("/add") //spring 4.3부터 GET/POST Mapping 지원
	public void add() {
		
		log.info("get...........");
		
	}
	
	@PostMapping(value = "/add", produces = "text/plain")
//	//여러개 value를 쓰려면 속성값을 주입해줘야 한다. produces - MIME Type / params도 잘 쓰면 좋다.
	@ResponseBody //이렇게 선언해주면 반환하는 자체가 response Data이다.
				//이게 없으면 return은 Data가 아니라 String타입 url주소이다.
	public String addPost(TodoDTO todoDTO) {
		
		log.info("========================");
		log.info(todoDTO);
		
//		Todo todo = Todo.builder()
//				.title(todoDTO.getTitle())
//				.complete(todoDTO.getComplete())
//				.build();
		
		return "success";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list..........");
		//원래라면 Mapper를 통해서 가져온 데이터를 가공해야 한다.
		
		//range - 1,10 = 1부터 9까지 / rangeClosed - 1,10 = 1부터 10까지
		List<TodoDTO> list = IntStream.rangeClosed(1, 10).mapToObj(i -> {
			TodoDTO dto = new TodoDTO();
			dto.setTno(i);
			dto.setTitle("aaaa" + i);
			return dto;
		}).collect(Collectors.toList());
		//각각의 i를 가지고 TodoDTO를 만들고, collect로 list로 묶는다.
		
		model.addAttribute("list", list); //Type의 앞글자를 소문자로 바꿔준다.
										  //List -> list
	}
	
}
