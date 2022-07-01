package com.culture.dto;

import javax.validation.constraints.NotBlank;

import com.culture.constant.CategoryStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardReviewDto {
	
	private Long bno;
	
	private String create_by;

	private CategoryStatus categoryStatus ;
	
	private String b_title;
	
	private String b_content;

	private LocalDateTime b_regdate;

	private Integer b_readhit;

}
