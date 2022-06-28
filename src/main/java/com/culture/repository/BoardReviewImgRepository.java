package com.culture.repository;

import com.culture.entity.BoardReviewImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardReviewImgRepository extends JpaRepository<BoardReviewImg, Long> {
    List<BoardReviewImg> findByBoardReviewBnoOrderByBnoAsc(Long bno);
}
