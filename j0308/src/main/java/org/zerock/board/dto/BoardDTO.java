package org.zerock.board.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BoardDTO {

	private Integer bno;
	private String title;
	private String content;
	@NotEmpty //Valid 걸어주는것
	private String writer;
	private Date regDate, updateDate;
	
}
