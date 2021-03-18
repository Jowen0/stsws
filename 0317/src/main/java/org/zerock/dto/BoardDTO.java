package org.zerock.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {
	
	private Integer bno;
	private String title, content, writer;
	
	private List<AttachFileDTO> fileList;
	
}
