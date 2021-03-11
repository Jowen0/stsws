package org.tufcookie.board.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
	
	private Integer bno;
	private String title, content, writer;
	private Date regdate,updateDate;

}
