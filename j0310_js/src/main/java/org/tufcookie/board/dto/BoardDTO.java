package org.tufcookie.board.dto;



import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDTO {
	
	private Integer bno;
	private String title, content, writer;
	private Date regDate, updateDate;

}
