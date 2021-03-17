package org.zerock.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.domain.Board;

public interface BoardMapper {
	
	List<Board> getList(@Param("skip") int skip, 
						@Param("count") int count, 
						@Param("arr")String[] arr,
						@Param("keyword") String keyword);
						//DTO를 넣지 않고 이렇게 Param으로 넣는 이유: DTO가 Mapper로 넘어가는게 싫기 때문이다.
						//select option으로 검색
	
	int getTotalCount(@Param("arr")String[] arr,
					  @Param("keyword") String keyword);
	
	void insert(Board board);
	
	//List<Board> ex1(PageDTO dto); //체크박스로 검색 하는 방법
	
	Board selectOne(Integer bno);
	
}
