package com.culture.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainBoardReviewDto {
    private Long bno;
    private String b_category;
    private String b_title;
    private String b_content;
    private String b_image;

    @QueryProjection
    public MainBoardReviewDto(Long bno, String b_category, String b_title, String b_content, String b_image){
        this.bno = bno;
        this.b_category = b_category;
        this.b_title = b_title;
        this.b_content = b_content;
        this.b_image = b_image;
    }
}
