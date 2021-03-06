package org.tufcookie.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tufcookie.board.service.BoardService;
import org.tufcookie.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping({"/list", "/"})
	public String getList(PageDTO pageDTO, Model model) {
		
		log.info("list.................");
		
		model.addAttribute("list", service.getList(pageDTO));
		
		return "/board/list";
	}
	
}
