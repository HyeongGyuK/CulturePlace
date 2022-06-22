package com.culture.dto;

import com.culture.entity.BoardFree;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardFreeDto {
	private Long board_no;
	private String board_writer;
	private String board_title;
	private String board_content;
	private LocalDateTime board_regdate;
	private Integer board_readhit;

	private static ModelMapper modelMapper = new ModelMapper();

    public BoardFree boardWrite() {
		return modelMapper.map(this, BoardFree.class); // source는 boardWrite 자신을 뜻한다.
	}

	public static BoardFreeDto of(BoardFree boardFree) {
		return modelMapper.map(boardFree, BoardFreeDto.class);
	}
}