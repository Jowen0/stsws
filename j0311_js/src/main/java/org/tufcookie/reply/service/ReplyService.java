package org.tufcookie.reply.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tufcookie.reply.domain.ReplyVO;

public interface ReplyService {
	
	void register(ReplyVO vo);
	
	ReplyVO readOne(Integer rno);
	
	void modify(ReplyVO vo);
	
	void remove(Integer rno);
	
	List<ReplyVO> getList(@Param("bno") Integer bno, @Param("skip") int skip);
	
}
