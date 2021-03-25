package org.tufcookie.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tufcookie.reply.domain.ReplyVO;
import org.tufcookie.reply.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper mapper;
	
	@Override
	public void register(ReplyVO vo) {
		
		mapper.insert(vo);
		
	}

	@Override
	public ReplyVO readOne(Integer rno) {
		
		
		return mapper.selectOne(rno);
		
	}

	@Override
	public void modify(ReplyVO vo) {
		
		mapper.update(vo);
		
	}

	@Override
	public void remove(Integer rno) {
		
		mapper.delete(rno);
		
	}

	@Override
	public List<ReplyVO> getList(Integer bno, int skip) {
		
		return mapper.selectList(bno, skip);
		
	}

}
