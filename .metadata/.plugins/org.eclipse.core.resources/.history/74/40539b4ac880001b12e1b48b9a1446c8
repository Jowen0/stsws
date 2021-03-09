package org.tufcookie.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.tufcookie.board.dto.BoardDTO;

public interface BoardMapper {
	
	@Select("select * from tbl_board order by bno desc limit 0, 10")
	List<BoardDTO> getList();

}
