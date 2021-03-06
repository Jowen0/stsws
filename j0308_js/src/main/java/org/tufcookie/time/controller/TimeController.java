package org.tufcookie.time.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tufcookie.time.service.TimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
@RequestMapping("/time")
public class TimeController {

	private final TimeService timeService;
	
	@GetMapping("/now")
	public void getTime(Model model) {
		
		model.addAttribute("time", timeService.getTime());
		
	}
	
}
