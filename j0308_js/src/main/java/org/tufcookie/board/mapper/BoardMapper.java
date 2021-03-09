package org.tufcookie.board.mapper;

import java.util.List;

import org.tufcookie.board.domain.Board;
import org.tufcookie.common.dto.PageDTO;

public interface BoardMapper {
	
	List<Board> getList(PageDTO pageDTO);

}
