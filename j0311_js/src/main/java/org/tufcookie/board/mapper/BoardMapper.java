package org.tufcookie.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tufcookie.board.domain.Board;

public interface BoardMapper {
	
	List<Board> getList(@Param("skip") Integer skip,
						@Param("perSheet") Integer perSheet,
						@Param("arr") String[] arr,
						@Param("keyword") String keyword);
	
	Integer getTotalCount(@Param("arr") String[] arr,
						  @Param("keyword") String keyword);
	
	void insert(Board board);
	
	Board selectOne(Integer bno);
	
	void update(Board board);
	
	void delete(Integer bno);
	
}
