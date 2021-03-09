package org.zerock.ui;

import org.zerock.service.MenuService;

public class MenuUI {
	
	private MenuService service;
	
	//의존성 주입
	//생성자 주입 / setter 주입 / 필드 주입
	//2. setter 주입: 생성자 - 제한
	public void setService(MenuService service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "MenuUI [service=" + service + "]";
	}
	
}
