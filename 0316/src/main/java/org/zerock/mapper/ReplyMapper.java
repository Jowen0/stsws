package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply (bno, reply, replyer) values (#{bno}, #{reply}, #{replyer})")
	void insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where rno = #{rno}")
	ReplyVO selectOne(Integer rno);
	
	@Update("update tbl_reply set reply = #{reply}, updateDate = now() where rno = #{rno}")
	void update(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	void delete(Integer rno);
	
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc limit #{skip}, 10")
	List<ReplyVO> selectList(@Param("bno") Integer bno, @Param("skip") int skip);

}
