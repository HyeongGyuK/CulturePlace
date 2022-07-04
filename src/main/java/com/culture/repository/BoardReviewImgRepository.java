package com.culture.repository;

import com.culture.entity.BoardReview;
import com.culture.entity.BoardReviewImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardReviewImgRepository extends JpaRepository<BoardReviewImg, Long> {
    List<BoardReviewImg> findByBoardReviewBnoOrderByBnoAsc(Long bno);

    @Modifying
    @Query("select bno, b_content, b_readhit, b_regdate, b_title, b_writer, categoryStatus from BoardReview b where b.bno = :bno")
    BoardReview findBoardReviewData(Long bno);

    @Modifying
    @Query("delete from BoardReviewImg b where b.bno = :bno")
    void deleteImgQuery(Long bno);
}
