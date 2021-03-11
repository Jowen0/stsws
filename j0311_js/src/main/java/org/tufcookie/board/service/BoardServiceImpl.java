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
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getListPage(PageDTO pageDTO) {
	
		return mapper.getList(pageDTO.getSkip(), pageDTO.getPerSheet(), pageDTO.getArr(), pageDTO.getKeyword())
				.stream()
				.map(board -> toDTO(board))
				.collect(Collectors.toList());
		
	}

	@Override
	public Integer getTotal(PageDTO pageDTO) {
		
		return mapper.getTotalCount(pageDTO.getArr(), pageDTO.getKeyword());
	}

}
