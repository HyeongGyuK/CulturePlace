package com.culture.dto.BoardFreeDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardFreeDto {
	private Long board_no;
	private String board_writer;
	private String board_title;
	private String board_content;
	private LocalDateTime board_regdate;
}