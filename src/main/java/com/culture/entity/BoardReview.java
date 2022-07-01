package com.culture.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.culture.constant.CategoryStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "boardReview")
@Getter @Setter
public class BoardReview extends BaseEntity{
	
	@Id
	@Column(name = "bno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long bno; // PK

	@CreatedBy
	@Column(updatable = false, nullable = false)
	private String b_writer; // 작성자

	@Enumerated(EnumType.STRING)
	private CategoryStatus categoryStatus ; //카테고리

	@Column(nullable = true, length = 50)
	private String b_title; // 제목
	
	@Column(nullable = true, length = 50)
	private String b_content; // 내용

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime b_regdate; // 작성일자
	
	@Column(nullable = true)
	private Integer b_readhit; // 조회수
	
	
}