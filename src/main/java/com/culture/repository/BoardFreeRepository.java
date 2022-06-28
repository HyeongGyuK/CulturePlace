package com.culture.repository;

import com.culture.entity.boardFree.BoardFree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardFreeRepository extends JpaRepository<BoardFree, Long>,
	QuerydslPredicateExecutor<BoardFree>, BoardFreeRepositoryCustom{
	// ItemRepositoryCustom을 상속받는 interface
}
