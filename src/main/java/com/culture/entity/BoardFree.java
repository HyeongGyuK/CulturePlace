package com.culture.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boardFree")
@Getter @Setter
public class BoardFree {
	
	@Id
	@Column(name = "board_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long board_no; // PK
	
	@Column(nullable = true, length = 50)
	private String board_title; // 제목
	
	@Lob
	@Column(nullable = true, length = 50)
	private String board_content; // 내용
	
	@Column(nullable = true)
	private String board_writer; // 작성자, fk = ManyToOne
	
	@Column(nullable = true)
	private LocalDateTime board_regdate; // 작성 일자
	
	@Column(nullable = true)
	private Integer board_readhit; // 조회수
	
	
}