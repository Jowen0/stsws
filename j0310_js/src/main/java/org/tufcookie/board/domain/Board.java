package org.tufcookie.board.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class Board {
	
	private Integer bno;
	private String title, content, writer;
	private Date regDate, updateDate;
	
}
