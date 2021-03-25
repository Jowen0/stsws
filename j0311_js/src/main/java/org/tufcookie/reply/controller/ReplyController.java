package org.tufcookie.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tufcookie.reply.domain.ReplyVO;
import org.tufcookie.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService service;
	
	@PutMapping("/{rno}")
	public ResponseEntity<ReplyVO> modifyReply(@RequestBody ReplyVO vo) {
		
		log.info("modify.............................");
		log.info("DTO: " + vo);
		//log.info("SNO: " + sno);
		
		return new ResponseEntity<ReplyVO>(vo, HttpStatus.OK);
	}
	
	@DeleteMapping("/{rno}") //제네릭 자체가 기본자료형을 사용할 수 없다 - 제네릭???
	public ResponseEntity<Boolean> removeReply(@PathVariable(name="sno") Integer sno){
		//위험한 방법: ID가 노출 된다
		log.info("SNO: " + sno);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@PostMapping("/{rno}")
	public ResponseEntity<ReplyVO> postReply(@PathVariable(name="cat") Long cat,
												@RequestParam(name="perSheet") Integer perSheet,
												@RequestBody ReplyVO vo){
		
		log.info(cat);
		log.info(perSheet);
		log.info(vo);
		
		return new ResponseEntity<ReplyVO>(vo, HttpStatus.OK);
		
	}
	
	//@ResponseBody 생략가능 - @RestController에 포함
	//comsumes - 어떤 타입만 받겠다, produces - 어떤 타입만 만들겠다.
	@GetMapping(value = "/get1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getReply(Integer bno, int skip, Model model) {
		
		model.addAttribute("pageMaker", 1);
		
		return new ResponseEntity<List<ReplyVO>>(service.getList(bno, skip), HttpStatus.OK);
		
	}
	
}
