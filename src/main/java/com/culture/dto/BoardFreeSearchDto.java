package com.culture.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardFreeSearchDto {
	private String searchBy; // 검색 필드
	private String searchQuery; // 제목 키워드
}