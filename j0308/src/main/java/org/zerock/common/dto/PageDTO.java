package org.zerock.common.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO {
	
	@Builder.Default
	private int page = 1;
	@Builder.Default //이렇게 안하려면 생성자로 초기값을 줘야한다.
	private int perSheet = 10;
	
	//검색
	private String type; //t,tc,tcw
	private String keyword;
	
	public int getSkip() {
		
		//Getter로 깔끔하게 만들거나, Validation을 추가해서 예외처리를 한다.
		
		return (page - 1) * perSheet;
		
	}
	
	//tc -> [t,c] / tcw -> [t,c,w]
	public String[] getArr( ) {
		
		if(keyword == null || keyword.trim().length() == 0) {
			
			return null;
			
		}
		if(type == null) {
			
			return null;
			
		}
		return type.split("");
	}
	
	public Map<String, String> getMap() {
		
		Map<String, String> map = new HashMap<>();
		map.put("t", "10");
		
		return map;
		
	}
	
	
	
}
