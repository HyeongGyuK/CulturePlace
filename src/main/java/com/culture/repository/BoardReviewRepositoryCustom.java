package com.culture.repository;

import com.culture.dto.BoardReviewSearchDto;
import com.culture.dto.MainBoardReviewDto;
import com.culture.entity.BoardReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReviewRepositoryCustom {
    Page<BoardReview> getAdminBoardReviewPage(BoardReviewSearchDto boardReviewSearchDto, Pageable pageable);

    Page<MainBoardReviewDto> getMainBoardReviewPage(BoardReviewSearchDto boardReviewSearchDto, Pageable pageable);
}
