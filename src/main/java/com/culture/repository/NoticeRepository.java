package com.culture.repository;

import com.culture.entity.boardFree.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

public interface NoticeRepository extends JpaRepository<Notice, Long>,
        QuerydslPredicateExecutor<Notice>, NoticeRepositoryCustom {
    // 공지사항 Repository
}
