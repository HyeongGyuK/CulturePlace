package com.culture.repository;

import com.culture.entity.BoardReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardReviewRepository extends JpaRepository<BoardReview, Long>, QuerydslPredicateExecutor<BoardReview>, BoardReviewRepositoryCustom {

    // 리뷰게시판 제목으로 데이터를 조회합니다.
    List<BoardReview> findBybno(Long bno);

    @Modifying
    @Query("update BoardReview b set b.b_readhit = b.b_readhit + 1 where b.bno = :bno")
    int updateBoardReviewReadHit(Long bno);
}
