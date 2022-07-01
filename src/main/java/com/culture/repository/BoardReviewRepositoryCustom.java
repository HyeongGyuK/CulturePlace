package com.culture.repository;

import com.culture.dto.BoardReviewMainDto;
//import com.culture.dto.MainBoardReviewDto;
import com.culture.entity.BoardReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReviewRepositoryCustom {
    // boardReviewDto와 페이징 정보 pageable를 이용하여 데이터를 조회한다.
    Page<BoardReview> getAdminBoardReviewPage(Pageable pageable);

    // 메인 페이지에서 보여줄 리뷰이미지 구하기
    Page<BoardReviewMainDto> getMainBoardReviewPage(Pageable pageable);
}
