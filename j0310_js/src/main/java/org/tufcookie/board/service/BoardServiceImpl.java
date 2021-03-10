package org.tufcookie.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.tufcookie.board.dto.BoardDTO;
import org.tufcookie.board.mapper.BoardMapper;
import org.tufcookie.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> getListPage(PageDTO pageDTO) {
		
		return boardMapper.getList(pageDTO.getPage(), pageDTO.getPerSheet())
						  .stream()
						  .map(board -> toDTO(board)).collect(Collectors.toList());		
		
	}

	@Override
	public Integer getTotalCount(PageDTO pageDTO) {
		
		return boardMapper.getTotalCount(pageDTO);
	}

}
