package org.tufcookie.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tufcookie.board.service.BoardService;
import org.tufcookie.common.dto.PageDTO;
import org.tufcookie.common.dto.PageMaker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping({"list", "/"})
	public String getList(PageDTO pageDTO, Model model) {
		
		model.addAttribute("list", service.getListPage(pageDTO));
		model.addAttribute("pageMaker", new PageMaker(pageDTO, service.getTotal(pageDTO)));
		
		return "/board/list";
	}

}
