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
@Table(name = "boardReview")
@Getter @Setter
public class BoardReview {
	
	@Id
	@Column(name = "b_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long b_no; // PK
	
	@Column(nullable = true, length = 50)
	private String b_title; // 제목
	
	@Column(nullable = true, length = 50)
	private String b_content; // 내용
	
	@Column(nullable = true)
	private String b_writer; // 작성자
	
	@Column(nullable = true)
	private LocalDateTime b_regdate; // 작성일자
	
	@Column(nullable = true)
	private Integer b_readhit; // 조회수
	
	
}