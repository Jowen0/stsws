package org.zerock.service;

import java.util.List;

import org.zerock.domain.Menu;

public class MenuServiceImpl implements MenuService {
	
	private List<Menu> menus;
	
	//의존성 주입
	//생성자 주입 / setter 주입 / 필드 주입
	//1. 생성자 주입: 생성자 - 제한
	public MenuServiceImpl(List<Menu> menus) {
		super();
		this.menus = menus;
	}
	
	
	@Override
	public List<Menu> getAllmenus() {
		// TODO Auto-generated method stub
		return this.menus;
	}


}
