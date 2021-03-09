package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.entity.Todo;

public interface TodoMapper {
	//객체만 Bean이 될 수 있다. 인터페이스는 Bean이 될 수 없다.
	
	@Insert("insert into tbl_todo (title, complete) values(#{title}, #{complete})")
	void insert(Todo todo);
	
}
