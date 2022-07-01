package com.culture.repository;

import com.culture.dto.BoardReviewMainDto;
//import com.culture.dto.MainBoardReviewDto;
//import com.culture.dto.QMainBoardReviewDto;
import com.culture.dto.QBoardReviewMainDto;
import com.culture.entity.BoardReview;
import com.culture.entity.QBoardReview;
import com.culture.entity.QBoardReviewImg;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BoardReviewRepositoryCustomImpl implements BoardReviewRepositoryCustom{
    //쿼리를 생성하는 클래스로 엔터티관리자(EntityManager)를 매개변수로 넣어준다
    private JPAQueryFactory queryFactory;

    public BoardReviewRepositoryCustomImpl(EntityManager em){ //생성자
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override  // Page는 인터페이스. 이거를 구현하는 클래스가 PageImpl
    public Page<BoardReview> getAdminBoardReviewPage(Pageable pageable){
        QueryResults<BoardReview> results = this.queryFactory
                .selectFrom(QBoardReview.boardReview) //from 테이블명
                .orderBy(QBoardReview.boardReview.bno.desc())
                .offset(pageable.getOffset()) //시작하고자하고자하는 줄(글)(차감). no offset이면 첫줄부터 나옴
                .limit(pageable.getPageSize()) // 제한하고자 하는 줄(글) 갯수
                .fetchResults();

        List<BoardReview> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content,pageable,total);
    }

    //조건식을 판단하여 결과가 true인 데이터만 반환하는 클래스
    //BooleanExpression 추상클래스는 Predicate인터페이스를 상속받고 있음
/*    private BooleanExpression categoryStatusEq(BoardReviewSearchDto searchSellStatus) {
        // 3가지{판매상태(전체), 판매, 품절} 중에서 택1
        return searchSellStatus == null ? null : QBoardReview.boardReview.categoryStatus.eq(categoryStatusEq);
    }*/

    @Override
    public Page<BoardReviewMainDto> getMainBoardReviewPage(Pageable pageable) {
        QBoardReview boardReview = QBoardReview.boardReview;
        QBoardReviewImg boardReviewImg = QBoardReviewImg.boardReviewImg;

        QueryResults<BoardReviewMainDto> results = queryFactory
                .select(
                        new QBoardReviewMainDto(
                                boardReview.bno,
                                boardReviewImg.imgUrl,
                                boardReview.b_title)
                )
                .from(boardReviewImg)
                .join(boardReviewImg.boardReview, boardReview)
                .orderBy(boardReview.bno.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<BoardReviewMainDto> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }


    //    @Override
//    public Page<BoardReviewMainDto> getMainBoardReviewPage(Pageable pageable) {
//        QBoardReview boardReview = QBoardReview.boardReview ;
//        QBoardReviewImg boardReviewImg = QBoardReviewImg.boardReviewImg ;
//
//        QueryResults<BoardReviewMainDto> results = queryFactory
//                .select(
//                        new QMainBoardReviewDto(
//                                boardReview.bno,
//                                boardReview.categoryStatus,
//                                boardReview.b_title,
//                                boardReview.b_content,
//                                boardReview.b_regdate,
//                                boardReview.b_readhit,
//                                boardReviewImg.imgUrl)
//                )
//                .from(boardReviewImg)
//                .join(boardReviewImg.boardReview, boardReview)
//                .orderBy(boardReview.bno.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetchResults();
//
//        List<MainBoardReviewDto> content = results.getResults() ;
//        long total = results.getTotal() ;
//
//        return new PageImpl<>(content, pageable, total);
//    }
}


























