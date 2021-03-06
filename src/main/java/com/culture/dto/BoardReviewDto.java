package com.culture.dto;

import javax.validation.constraints.NotBlank;

import com.culture.constant.CategoryStatus;
import com.culture.entity.BoardReview;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BoardReviewDto {
	
	private Long bno;
	
	private String b_writer;

	private CategoryStatus categoryStatus ;
	
	private String b_title;
	
	private String b_content;

//	private LocalDateTime b_regdate;

	private String b_regdate;

	private int b_readhit;


	private static ModelMapper modelMapper = new ModelMapper();

	public static BoardReviewDto of(BoardReview boardReview){
		return modelMapper.map(boardReview, BoardReviewDto.class);
	}
}
