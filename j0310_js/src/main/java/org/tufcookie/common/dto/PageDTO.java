package org.tufcookie.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //일반 생성자를 만들면 이걸 추가해야 되는가?
public class PageDTO {
	
	private Integer page;
	private Integer perSheet;
	
	//Default 설정
	public PageDTO() {
		
		page = 1;
		perSheet = 10;
		
	}
	
	//MySQL limit skip, perSheet
	public Integer getskip() {
		
		return (page - 1) * perSheet ;
	}
	
}
