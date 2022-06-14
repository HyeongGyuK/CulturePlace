package com.culture.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.culture.dto.BoardFreeSearchDto;
import com.culture.entity.BoardFree;

public interface BoardFreeRepository extends JpaRepository<BoardFree, Long>,
	QuerydslPredicateExecutor<BoardFree>, BoardFreeRepositoryCustom{

	
}
