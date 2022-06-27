package com.culture.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardReviewDto {
	
	private Long b_no;
	
	private String b_writer;

	private String b_category;
	
	private String b_title;
	
	private String b_content;

	private LocalDateTime b_regdate;
	private Integer b_readhit;

}
