package com.culture.dto;

import com.culture.constant.CategoryStatus;
import com.culture.entity.BoardReview;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BoardReviewFormDto {
    private Long bno ;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private String b_category ;

    @NotBlank(message = "제목을 입력해주세요.")
    private String b_title ;

    @NotNull(message = "내용을 입력해주세요.")
    private String b_content ;
//
//    @NotBlank(message = "이미지를 첨부해주세요.")
//    private String b_image ;

    // 현재 쓰일지 안쓰일지 모르겠음
//    private CategoryStatus categoryStatus ;

    // 리뷰게시판 작성시 첨부할 이미지정보 저장
//    private BoardReviewImgDto boardReviewImgDto = new BoardReviewImgDto() ;
    private List<BoardReviewImgDto> boardReviewImgDtoList = new ArrayList<BoardReviewImgDto>();

    // 리뷰게시판 수정시 해당 이미지의 unique id 값 저장
    // ?
    private List<Long> boardReviewImgIds = new ArrayList<Long>();

    private static ModelMapper modelMapper = new ModelMapper() ;

    public BoardReview insertBoardReview(){
        return modelMapper.map(this, BoardReview.class) ;
    }

    public static BoardReviewFormDto of(BoardReview boardReview){
        return modelMapper.map(boardReview, BoardReviewFormDto.class);
    }
}
