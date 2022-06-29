package com.culture.repository;

import com.culture.dto.MainBoardReviewDto;
import com.culture.entity.BoardReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardReviewRepositoryCustom {
    Page<BoardReview> getAdminBoardReviewPage(Pageable pageable);

    Page<MainBoardReviewDto> getMainBoardReviewPage(Pageable pageable);
}
