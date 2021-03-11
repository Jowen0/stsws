package org.tufcookie.time.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tufcookie.time.service.TimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeController {
	
	@Autowired
	private final TimeService service;
	
	@GetMapping("/now")
	public void getTime(Model model) {
		
		model.addAttribute("time", service.getTime());
		
	}

}
