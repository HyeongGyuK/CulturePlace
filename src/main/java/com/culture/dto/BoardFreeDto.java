package com.culture.dto;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;

import com.culture.entity.BoardFree;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardFreeDto {
	
	private Long board_no;
	
	private String board_writer;
	
	@NotBlank(message = "제목을 입력하여 주세요.")
	private String board_title;
	
	@NotBlank(message = "내용을 입력하여 주세요.")
	private String board_content;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public BoardFree boardwrite() {
		return modelMapper.map(this, BoardFree.class);
	}
}