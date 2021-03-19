package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
//RequestMapping을 주지 않는 이유 - 나중에 공통으로 쓰기 위함
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		log.error("-------------------------");
		log.error(auth);
		
		model.addAttribute("msg", "권한이 없는 사용자입니다.");
		
	}
	
	@GetMapping("/customLogin")
	public void loginPage(String error, String logout, Model model) {
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		//logout
		if(logout != null) {
			
			model.addAttribute("logout", "Logout!!!");
			
		}
		
	}
	
	@GetMapping("/customLogout")
	public void customLogout() {
		
		
		
	}
	
}
