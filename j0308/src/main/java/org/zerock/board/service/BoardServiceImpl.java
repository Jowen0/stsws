package org.zerock.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.zerock.board.domain.Board;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.common.dto.PageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	//Default Method는 Override 되지 않는다.
	
	private final BoardMapper mapper;
	
	
	@Override
	public List<BoardDTO> getPageList(PageDTO pageDTO) {
		
		return mapper.getList(pageDTO.getSkip(),
							  pageDTO.getPerSheet(),
							  pageDTO.getArr(),
							  pageDTO.getKeyword())
		.stream().map(board -> toDTO(board)).collect(Collectors.toList());
		//stream : 빨대
		//stream 빨대로 넣어서 중간에 함수를 넣고, 뒤에 collect 빨대로 수집한다.
		//map - 
		//람다는 일반 메서드와 context가 달라진다. this가 달라진다. 안에 this를 쓸 수 없다.
		//모든 함수는 return이 있다.
		//{ }가 있으면 return을 선언 해줘야 한다. 없다면 안에 있는 값이 반환된다.(눈에 보이지 않는 리턴)
		
	}

	@Override
	public int getTotalCount(PageDTO pageDTO) {
		
		return mapper.getTotalCount(pageDTO.getArr(), pageDTO.getKeyword());
	}

	@Override
	public void register(BoardDTO boardDTO) {
		
		Board vo = toDomain(boardDTO); //기본적으로 static
		
		mapper.insert(vo);
		
	}

	@Override
	public BoardDTO readOne(Integer bno) {
		
		return toDTO(mapper.selectOne(bno) );
	}

}
