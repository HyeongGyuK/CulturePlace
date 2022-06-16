package com.culture.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardReviewDto {
	
	private Long b_no;
	
	private String b_writer;
	
	@NotBlank(message = "제목을 입력해주세요.")
	private String b_title;
	
	@NotBlank(message = "내용을 입력해주세요.")
	private String b_content;
	
//	private List<MultipartFile> imageFiles;
	
	
}
