package com.culture.repository;

import com.culture.entity.boardFree.BoardFreeReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardFreeReplyRepository extends JpaRepository<BoardFreeReply, Integer>,
        QuerydslPredicateExecutor<BoardFreeReply>, BoardFreeReplyRepositoryCustom {
}
