package org.tufcookie.board.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tufcookie.board.dto.BoardDTO;
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
	
	//목록 페이지
	@GetMapping({"/list", "/"})
	public String list(PageDTO pageDTO, Model model) {
		
		model.addAttribute("list", service.getListPage(pageDTO));
		model.addAttribute("pageMaker", new PageMaker(pageDTO, service.getTotal(pageDTO)));
		
		return "/board/list";
	}
	
	//등록 Get
	@GetMapping("/register")
	public void register() {
		
	}
	
	//등록 Post
	@PostMapping(value =  "/register", produces = {"text/plain"})
	@ResponseBody
	public ResponseEntity<String> registerPost(@RequestBody @Valid BoardDTO boardDTO, BindingResult result) {
		
		log.info("register post........");
		
		if(result.hasErrors()) {
			
			log.info("fail............");
			
			log.info(result.getAllErrors());
			
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		log.info("success..............");
		service.register(boardDTO);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Integer bno, PageDTO pageDTO, Model model) {
		
		model.addAttribute("board", service.readOne(bno));
		
	}
	
	/*
	 * @GetMapping("/modify") public void modify(Integer bno, Model model) {
	 * 
	 * model.addAttribute("board", service.readOne(bno));
	 * 
	 * }
	 */
	
	@PostMapping(value = "/modify", produces = {"text/plain"})
	@ResponseBody
	public ResponseEntity<String> modifyPost( @RequestBody @Valid BoardDTO boardDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			
			log.info(result.getAllErrors());
			
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		service.modify(boardDTO);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PostMapping(value = "/remove", produces = {"text/plain"})
	@ResponseBody
	public ResponseEntity<String> removePost( @RequestBody int bno, BindingResult result) {
		
		if(result.hasErrors()) {
			
			log.info(result.getAllErrors());
			
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		service.remove(bno);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

}
