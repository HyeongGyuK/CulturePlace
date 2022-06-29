package com.culture.dto;

import com.culture.constant.CategoryStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainBoardReviewDto {
    private Long bno;
    private String b_title;
    private String b_content;
    private CategoryStatus categoryStatus ;

    @QueryProjection
    public MainBoardReviewDto(Long bno, String b_category, String b_title, String b_content, String b_image){
        this.bno = bno;
        this.b_title = b_title;
        this.b_content = b_content;
        this.categoryStatus = categoryStatus;
    }
}
