package com.culture.entity.boardFree;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

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

	@Column(nullable = false)
	private Integer board_readhit; // 조회수
}