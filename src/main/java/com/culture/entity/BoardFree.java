package com.culture.entity;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "boardFree")
@Getter @Setter
@ToString
public class BoardFree {
	@Id
	@Column(name = "board_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long board_no; // PK

	@Column(nullable = true, length = 50)
	private String board_title; // 제목

	@Column(nullable = false, length = 50)
	private String board_content; // 내용

	@Column(nullable = true)
	private String board_writer; // 작성자, fk = ManyToOne & *********** member와 참조 무결정 제약조건 성립 필요 ***********

	@Column(nullable = true)
	private LocalDateTime board_regdate; // 작성 일자

	@Column(nullable = true)
	private Integer board_readhit; // 조회수

}