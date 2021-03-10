package org.zerock.board.service;

import java.util.List;

import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;
import org.zerock.common.dto.PageDTO;

public interface BoardService {
	
	List<BoardDTO> getPageList(PageDTO pageDTO);
	
	int getTotalCount();
	
	//만들어지는 게시물의 번호를 가져오려면 트랜잭션 기술이 필요하다.
	void register(BoardDTO boardDTO);
	
	default Board toDomain(BoardDTO dto) {
		//VO나 DTO가 서로를 알고 있는게 싫어서
		//인터페이스를 통해서 변형한다.
		//default 선언하면 추상메서드가 필요하지 않고, 일반 메서드로 작성 가능하다.
		//VO나 DTO에 쓸데없이 메서드가 있는 것 보다 깔끔해 보인다.
		
		return Board.builder().bno(dto.getBno())
		.title(dto.getTitle())
		.content(dto.getContent())
		.writer(dto.getWriter())
		.regDate(dto.getRegDate())
		.updateDate(dto.getUpdateDate())
		.build();
		
	}
	
}
