package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Restaurant {
	
	
	private final Chef chef;
	//의존성 주입
	//생성자 주입 / setter 주입 / 필드 주입
	//setter 주입

	public Restaurant(Chef chef) {
		super();
		this.chef = chef;
	}

	@Override
	public String toString() {
		return "Restaurant [chef=" + chef + "]";
	}
	
	
	
}
