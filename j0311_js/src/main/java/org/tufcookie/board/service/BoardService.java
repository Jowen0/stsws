package org.tufcookie.board.service;

import java.util.List;

import org.tufcookie.board.domain.Board;
import org.tufcookie.board.dto.BoardDTO;
import org.tufcookie.common.dto.PageDTO;

public interface BoardService {
	
	List<BoardDTO> getListPage(PageDTO pageDTO);
	
	Integer getTotal(PageDTO pageDTO);
	
	void register(BoardDTO boardDTO);
	
	BoardDTO readOne(Integer bno);
	
	void modify(BoardDTO boardDTO);
	
	void remove(Integer bno);
	
	
	
	default Board toDomain(BoardDTO dto) {
		
		return Board.builder()
					.bno(dto.getBno())
					.title(dto.getTitle())
					.content(dto.getContent())
					.writer(dto.getWriter())
					.regdate(dto.getRegdate())
					.updateDate(dto.getUpdateDate())
					.build();
		
	}
	
	default BoardDTO toDTO(Board board) {
		
		return BoardDTO.builder()
					.bno(board.getBno())
					.title(board.getTitle())
					.content(board.getContent())
					.writer(board.getWriter())
					.regdate(board.getRegdate())
					.updateDate(board.getUpdateDate())
					.build();
		
	}
	
}
