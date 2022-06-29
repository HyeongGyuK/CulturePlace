package com.culture.repository;

import com.culture.dto.BoardReviewSearchDto;
import com.culture.dto.MainBoardReviewDto;
import com.culture.dto.QMainBoardReviewDto;
import com.culture.entity.BoardReview;
import com.culture.entity.QBoardReview;
import com.culture.entity.QBoardReviewImg;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class BoardReviewRepositoryCustomImpl implements BoardReviewRepositoryCustom{
    private JPAQueryFactory queryFactory;

    public BoardReviewRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<BoardReview> getAdminBoardReviewPage(BoardReviewSearchDto boardReviewSearchDto, Pageable pageable) {
        QueryResults<BoardReview> results = this.queryFactory
                .selectFrom(QBoardReview.boardReview)
                .where(regDtsAfter(boardReviewSearchDto.getSearchDateType()),
                        searchByLike(boardReviewSearchDto.getSearchBy(), boardReviewSearchDto.getSearchQuery()))
                .orderBy(QBoardReview.boardReview.bno.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<BoardReview> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<MainBoardReviewDto> getMainBoardReviewPage(BoardReviewSearchDto boardReviewSearchDto, Pageable pageable) {
        QBoardReview boardReview = QBoardReview.boardReview;
        QBoardReviewImg boardReviewImg = QBoardReviewImg.boardReviewImg;

        QueryResults<MainBoardReviewDto> results = queryFactory
                .select(
                        new QMainBoardReviewDto(
                                boardReview.bno,
                                boardReview.categoryStatus, //
                                boardReview.b_title,
                                boardReview.b_content,
                                boardReviewImg.imgUrl
                        )
                ).from(boardReviewImg)
                .join(boardReviewImg.boardReview, boardReview)
                .where(boardReviewBNoLike(boardReviewSearchDto.getSearchQuery()))
                .orderBy(boardReview.bno.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<MainBoardReviewDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("bno", searchBy)){
            return QBoardReview.boardReview.bno.like("%" + searchQuery + "%");
        }else if(StringUtils.equals("createBy", searchBy)){
            return QBoardReview.boardReview.createBy.like("%" + searchQuery + "%");
        }

        return null;
    }

    private BooleanExpression boardReviewBNoLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery) ? null : QBoardReview.boardReview.bno.like("%" + searchQuery + "%");
    }

    private BooleanExpression regDtsAfter(String searchDateType){
        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all", searchDateType) || searchDateType == null){
            return null;
        }else if(StringUtils.equals("1d", searchDateType)){
            dateTime = dateTime.minusDays(1);
        }else if(StringUtils.equals("1w", searchDateType)){
            dateTime = dateTime.minusWeeks(1);
        }else if(StringUtils.equals("1m", searchDateType)){
            dateTime = dateTime.minusMonths(1);
        }else if(StringUtils.equals("6m", searchDateType)){
            dateTime = dateTime.minusMonths(6);
        }

        return QBoardReview.boardReview.b_regdate.after(dateTime);
    }
}



























