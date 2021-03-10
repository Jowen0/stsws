package org.tufcookie.board.service;

import java.util.List;

import org.tufcookie.board.domain.Board;
import org.tufcookie.board.dto.BoardDTO;
import org.tufcookie.common.dto.PageDTO;

public interface BoardService {
	
	//게시판 리스트 조회
	List<BoardDTO> getListPage(PageDTO pageDTO);
	
	//전체 데이터 개수 조회
	Integer getTotalCount(PageDTO pageDTO);
	
	//VO를 DTO 변환
	default Board toDomain(BoardDTO dto) {
		
		return Board.builder()
				.bno(dto.getBno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.regDate(dto.getRegDate())
				.updateDate(dto.getUpdateDate())
				.build();
	}
	
	//DTO를 VO 변환
	default BoardDTO toDTO(Board board) {
		
		return BoardDTO.builder()
		.bno(board.getBno())
		.title(board.getTitle())
		.content(board.getContent())
		.writer(board.getWriter())
		.regDate(board.getRegDate())
		.updateDate(board.getUpdateDate())
		.build();
		
	}
	
}
