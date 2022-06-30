package com.culture.repository;

import com.culture.entity.boardFree.BoardFree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardFreeRepository extends JpaRepository<BoardFree, Long>,
	QuerydslPredicateExecutor<BoardFree>, BoardFreeRepositoryCustom{
	// ItemRepositoryCustom을 상속받는 interface

	@Modifying
	@Query("update BoardFree b set b.board_readhit = b.board_readhit + 1 where b.board_no = :board_no")
	int updateBoardFreeReadHit(Long board_no);
}
