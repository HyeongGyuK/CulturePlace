//package com.culture.repository;
//
//import com.culture.dto.BoardFreeDto.NoticeDto;
//import com.culture.dto.BoardFreeDto.QNoticeDto;
//import com.culture.entity.boardFree.Notice;
//import com.culture.entity.boardFree.QNotice;
//import com.querydsl.core.QueryResults;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//// 공지사항 페이징 처리를 위한 interface 구현체
//public class NoticeRepositoryImpl implements NoticeRepositoryCustom{
//    private JPAQueryFactory queryFactory;
//
//    public NoticeRepositoryImpl(EntityManager em){
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
//    @Override
//    public Page<NoticeDto> getNoticePage(Pageable pageable) {
//        QNotice notice = QNotice.notice;
//
//        QueryResults<NoticeDto> results = queryFactory
//                .selectFrom(QNotice.notice)
//                .where
//
//
//        List<Notice> content = results.getResults();
//        Long total = results.getTotal();
//
//        return new PageImpl<>(content, pageable, total);
//    }
//}
