package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.TimeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller //빈 등록이 끝났다.
@Log4j
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
	
	private final TimeMapper timeMapper;
	
	@RequestMapping("/doA")
	public void doA(Model model) {
		
		log.info("doA.........");
		String now = timeMapper.getTime();
		log.info(now);
		model.addAttribute("time", now);
		
	}
	
}
