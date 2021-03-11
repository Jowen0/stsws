package org.tufcookie.time.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tufcookie.time.mapper.TimeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{

	@Autowired
	private final TimeMapper mapper;
	
	@Override
	public String getTime() {
		
		return mapper.getTime();
		
	}

	@Override
	public String getTime2() {
		 
		return mapper.getTime2();
		
	}

}
