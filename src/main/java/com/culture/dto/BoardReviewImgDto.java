package com.culture.dto;

import org.modelmapper.ModelMapper;

public class BoardReviewImgDto {
    private Long id ;
    private String imgName ;
    private String oriImgName ;
    private String imgUrl ;

    // mapper 객체 생성
    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardReviewImgDto of(BoardReviewImgDto BoardReviewImg){
        // 이미지 정보를 이용하여 상품 dto 객체로 변환
        return modelMapper.map(BoardReviewImg, BoardReviewImgDto.class) ;
    }
}
