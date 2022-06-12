package com.culture.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boardFree")
@Getter @Setter
public class BoardFree {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long board_no; // PK
	
	private String board_title; // 제목
	
	private String board_content; // 내용
	
	private String board_writer; // 작성자
	
	private LocalDateTime board_regdate; // 작성 일자
	
	private Integer board_readhit; // 조회수
	
	
}