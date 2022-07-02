package com.culture.repository;

import com.culture.entity.boardFree.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NoticeRepository extends JpaRepository<Notice, Long>,
        QuerydslPredicateExecutor<Notice>, NoticeRepositoryCustom {

    @Modifying
    @Query("update Notice n set n.notice_readhit = n.notice_readhit + 1 where n.notice_no = :notice_no")
    int updateNoticeReadHit(Long notice_no);
    // 공지사항 Repository
}
