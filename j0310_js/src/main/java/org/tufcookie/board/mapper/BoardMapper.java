package org.tufcookie.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tufcookie.board.domain.Board;
import org.tufcookie.common.dto.PageDTO;

public interface BoardMapper {
	
	//게시판 리스트 조회
	List<Board> getList(@Param("skip") int skip, 
						@Param("perSheet") int perSheet); //@Param을 쓰면 2개이상 파라미터 사용 가능
	
	//전체 데이터 개수 조회
	int getTotalCount(PageDTO pageDTO);

}
