package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select now()")
	String getTime();
	//이 방식은 많이 사용되지 않는다 - 이유: 실무에서는 SQL이 엄청 길기 때문이다.
	
	//때문에 이렇게 메소드만 정의한 후 XML 파일을 여기에 집어 넣어 준다.
	String getTime2();
	
	
	
}
