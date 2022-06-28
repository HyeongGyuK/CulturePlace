package com.culture.dto;

import com.culture.entity.BoardReviewImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class BoardReviewImgDto {
    private Long bno ;
    private String imgName ;
    private String oriImgName ;
    private String imgUrl ;

    // mapper 객체 생성
    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardReviewImgDto of(BoardReviewImg BoardReviewImg){
        // 이미지 정보를 이용하여 리뷰 dto 객체로 변환
        return modelMapper.map(BoardReviewImg, BoardReviewImgDto.class) ;
    }
}
