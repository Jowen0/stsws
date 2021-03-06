package org.tufcookie.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tufcookie.board.dto.BoardDTO;
import org.tufcookie.board.mapper.BoardMapper;
import org.tufcookie.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> getList(PageDTO pageDTO) {
		
		List<BoardDTO> list = new ArrayList<>();
		
		boardMapper.getList(pageDTO).forEach(board -> {
			
			BoardDTO boardDTO= BoardDTO.builder()
			.bno(board.getBno())
			.title(board.getTitle())
			.content(board.getContent())
			.writer(board.getWriter())
			.build();
			
			list.add(boardDTO);
			
		});
		
		return list;
		
		
		
	}

}
