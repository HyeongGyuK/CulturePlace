package com.culture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoardReviewSearchDto {
    private String searchDateType;
    private String searchBy;
    private String searchQuery = "";
}
