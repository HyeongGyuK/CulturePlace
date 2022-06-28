package com.culture.dto.BoardFreeDto;//package com.culture.dto;
//
//import java.time.LocalDateTime;
//
//import com.querydsl.core.annotations.QueryProjection;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter @Setter
//public class BoardFreeListDto {
//	private Long board_no;
//	private String board_writer;
//	private String board_title;
//	private String board_content;
//	private LocalDateTime board_regdate;
//	private Integer board_readhit;
//
//	@QueryProjection // 테이블에서 특정 컬럼을 추출하기 위한 Annotation
//	public BoardFreeListDto(Long board_no, String board_writer, String board_title, String board_content, LocalDateTime board_regdate, Integer board_readhit) {
//		this.board_no = board_no;
//		this.board_writer = board_writer;
//		this.board_title = board_title;
//		this.board_content = board_content;
//		this.board_regdate = board_regdate;
//		this.board_readhit = board_readhit;
//	}
//}
