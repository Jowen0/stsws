package org.zerock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.SampleMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	
	private final SampleMapper mapper;
	
	@Transactional
	@Override
	public String doA() {
		log.info("doA...............");
		
		String str = "가나다라마바사아자차카타파하ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		mapper.insert1(str);
		mapper.insert2(str);
		
		return "doA";
				
	}

	@Override
	public String doB() {
		log.info("doB..................");
		
		mapper.insert3("AAA", "BBB", "CCC");
		
		log.info("---------------------------------------------------------------");
		log.info("---------------------------------------------------------------");
		log.info(mapper.getLast());
		log.info("---------------------------------------------------------------");
		
		return "doB";
	}

	@Override
	public String doC() {
		log.info("doC.....................");
		return "doC";
	}

}
