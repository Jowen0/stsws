package org.tufcookie.time.service;

import org.springframework.stereotype.Service;
import org.tufcookie.time.mapper.TimeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{
	
	private final TimeMapper timeMapper;
	
	@Override
	public String getTime() {
		
		return timeMapper.getTime();
		
	}
	
}
