package com.culture.dto;

import com.culture.constant.CategoryStatus;
import com.culture.entity.BoardReview;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class BoardReviewFormDto {
    private Long id ;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private String b_category ;

    @NotBlank(message = "제목을 입력해주세요.")
    private String b_title ;

    @NotNull(message = "내용을 입력해주세요.")
    private Integer b_content ;

    @NotBlank(message = "이미지를 첨부해주세요.")
    private String b_image ;

    private CategoryStatus categoryStatus ;

    // 리뷰게시판 작성시 첨부할 이미지정보 저장
    private BoardReviewImgDto boardReviewImgDto = new BoardReviewImgDto() ;

    // 리뷰게시판 수정시 해당 이미지의 unique id 값 저장
    // ?

    private static ModelMapper modelMapper = new ModelMapper() ;

    public BoardReview insertBoardReview(){
        return modelMapper.map(this, BoardReview.class) ;
    }

    public static BoardReviewFormDto of(BoardReview boardReview){
        return modelMapper.map(boardReview, BoardReviewFormDto.class);
    }
}
