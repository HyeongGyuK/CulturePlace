package com.culture.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardReviewDto {
	
	private Long b_no;
	
	private String b_writer;

	@NotBlank(message = "카테고리를 입력해주세요.")
	private String b_category;
	
	@NotBlank(message = "제목을 입력해주세요.")
	private String b_title;
	
	@NotBlank(message = "내용을 입력해주세요.")
	private String b_content;

	private LocalDateTime b_regdate;
	private Integer b_readhit;

}
