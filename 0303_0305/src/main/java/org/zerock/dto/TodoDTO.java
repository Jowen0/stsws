package org.zerock.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
public class TodoDTO {
	
	private Integer tno; //int는 기본적으로 0이라는 값을 가지기 때문에 Integer를 쓴다.
	
	@NotEmpty //Java Validation
	@Length(min=5, max=10) //hibernate Validation
	private String title;
//	@Builder.Default
//	private Boolean complete = false; //기본값 null
	private Boolean complete;
	
}
