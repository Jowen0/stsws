package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.zerock.domain.Todo;


public interface TodoMapper {
	
	@Insert("insert into tbl_todo2 (title, complete) values(#{title}, #{complete})")
	void insert(Todo todo);
	
	List<Todo> selectAll();
	
}
