package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.dto.BoardDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@GetMapping("/register")
	public void registerGet() {
		
		
		
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String registerPost(@RequestBody BoardDTO dto) {
		
		log.info("post.................");
		log.info(dto);
		
		return "success";
		
	}
	
}
