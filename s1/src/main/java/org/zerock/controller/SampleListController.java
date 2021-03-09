package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Store;

@RestController
public class SampleListController {
	
	@GetMapping("/api/list")
	public List<Store> getList() {
		//1. 리스트 데이터를 만든다. 1) 리스트에 스토어를 담는다.
		List<Store> storeList = new ArrayList<>();
		storeList.add(Store.builder().name("AAA").lat(37.123456).lng(127.123456).build());
		storeList.add(Store.builder().name("BBB").lat(37.123456).lng(127.123456).build());
		storeList.add(Store.builder().name("CCC").lat(37.123456).lng(127.123456).build());
		storeList.add(Store.builder().name("DDD").lat(37.123456).lng(127.123456).build());
		storeList.add(Store.builder().name("EEE").lat(37.123456).lng(127.123456).build());
		
		return storeList;
	}
}
