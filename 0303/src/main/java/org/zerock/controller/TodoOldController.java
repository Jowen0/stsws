package org.zerock.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.TodoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todoOld/*") //안전하게 ("/todo/*")선언 //요즘 트랜드 - 43분
@Log4j
@RequiredArgsConstructor
public class TodoOldController {
	
	@GetMapping({"/addOld","/addOld2"}) //spring 4.3부터 GET/POST Mapping 지원
	public void add() {
		
		log.info("get...........");
		
	}
	
	@PostMapping("addOld")
	public String addPost(@Valid TodoDTO todoDTO, BindingResult result, RedirectAttributes rttr) {
		
		log.info("========================");
		log.info(todoDTO);
		
		//hasErrors - 에러가 있다면
		if(result.hasErrors()) {
			log.info("has errors" + result);
			return "/todoOld/addOld";
		}
										
//		return "redirect:/todo/list?msg=success"; //과거전통적인 방식
												//뒤에 파라미터를 url에 붙인다.
		
		//RedirctAttributes rttr이 추가되고
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/todoOld/listOld";
		
	}
	
	@PostMapping("addOld2")
	@ResponseBody
	public Object add2Post(@Valid TodoDTO todoDTO, BindingResult result) {
		
		log.info("========================");
		log.info(todoDTO);
		
		//hasErrors - 에러가 있다면
		if(result.hasErrors()) {
			log.info("has errors" + result);
			
			return result.getAllErrors();
		}
		
		return null;
		
	}
	
	@GetMapping("/listOld")
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
