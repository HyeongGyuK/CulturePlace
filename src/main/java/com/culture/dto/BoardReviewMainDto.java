package com.culture.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardReviewMainDto {
    private Long bno;
    private String imgUrl;
    private String b_title;

    @QueryProjection // Projection이라는 용어는 테이블에서 특정 컬럼들을 추출해내는 동작을 의미합니다.
    // Entity가 아닌 다른 객체(dto)들을 querydsl에 사용하고자 할때 이 어노테이션을 사용하면 됩니다.
    public BoardReviewMainDto(Long bno, String imgUrl, String b_title){
        this.bno = bno;
        this.imgUrl = imgUrl ;
        this.b_title = b_title;
    }
}
