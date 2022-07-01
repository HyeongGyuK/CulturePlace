package com.culture.entity.boardFree;

import com.culture.dto.BoardFreeDto.BoardFreeWriteDto;
import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "boardFree")
@Getter @Setter
@ToString
public class BoardFree extends BoardFreeBaseEntity{
	@Id
	@Column(name = "board_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long board_no; // PK

	@Column(nullable = false, length = 50)
	private String board_title; // 제목

	@Column(nullable = false)
	private String board_content; // 내용

	// Long Type은 게시글 생성시에 null값을 피하기 위해 지정하였다.
	@Column(columnDefinition = "integer default 0", nullable = false)
	private Long board_readhit; // 조회수

	public void updateBoardFree(BoardFreeWriteDto boardFreeWriteDto) {
		this.board_title = boardFreeWriteDto.getBoard_title();
		this.board_content = boardFreeWriteDto.getBoard_content();
	}
}