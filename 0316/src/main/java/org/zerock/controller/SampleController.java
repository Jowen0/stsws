package org.zerock.controller;

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
import org.zerock.domain.ReplyVO;
import org.zerock.domain.SampleDTO;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@CrossOrigin(origins = "*")
@RestController
@Log4j
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {
	
	private final ReplyMapper mapper;
	
	@PutMapping("/{sno}")
	public ResponseEntity<SampleDTO> modify(@RequestBody SampleDTO dto) {
		
		log.info("modify.............................");
		log.info("DTO: " + dto);
		//log.info("SNO: " + sno);
		
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{sno}") //제네릭 자체가 기본자료형을 사용할 수 없다 - 제네릭???
	public ResponseEntity<Boolean> removeSample(@PathVariable(name="sno") Integer sno){
		//위험한 방법: ID가 노출 된다
		log.info("SNO: " + sno);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@PostMapping("/{cat}")
	public ResponseEntity<SampleDTO> postSample(@PathVariable(name="cat") Long cat,
												@RequestParam(name="perSheet") Integer perSheet,
												@RequestBody SampleDTO dto){
		
		log.info(cat);
		log.info(perSheet);
		log.info(dto);
		
		return new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
		
	}
	
	//@ResponseBody 생략가능 - @RestController에 포함
	//comsumes - 어떤 타입만 받겠다, produces - 어떤 타입만 만들겠다.
	@GetMapping(value = "/get1", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getSample(Integer bno, int skip, Model model) {
		
		model.addAttribute("pageMaker", 1);
		
		return new ResponseEntity<List<ReplyVO>>(mapper.selectList(bno, skip), HttpStatus.OK);
		
	}
	
}
