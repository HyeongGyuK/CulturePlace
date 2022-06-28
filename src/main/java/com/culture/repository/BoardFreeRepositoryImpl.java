package com.culture.repository;

import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;

import com.culture.entity.boardFree.BoardFree;
import com.culture.entity.boardFree.QBoardFree;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

// 자유 게시판 글 목록 조회에 대한 interface를 구현하기 위한 클래스 입니다.
public class BoardFreeRepositoryImpl implements BoardFreeRepositoryCustom{

	private JPAQueryFactory queryFactory; // 질의어 대행

	public BoardFreeRepositoryImpl(EntityManager em) { // BoardFreeRepositoryImpl 본인에 대한 객체화
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable) {
		QueryResults<BoardFree> results = this.queryFactory // 페이징에 대한 정보와 데이터 목록을 가지고 있는 객체
				.selectFrom(QBoardFree.boardFree)
				.where(searchByLike(boardFreeSearchDto.getSearchBy(), boardFreeSearchDto.getSearchQuery()))
				.orderBy(QBoardFree.boardFree.board_no.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetchResults();

		System.out.println("");

		List<BoardFree> content = results.getResults();
        Long total = results.getTotal();

		return new PageImpl<>(content, pageable, total);
	}

	private BooleanExpression board_writerLike(String searchQuery) {
			return StringUtils.isEmpty(searchQuery) ? null : QBoardFree.boardFree.board_writer.like("%" + searchQuery + "%");
	}

	private BooleanExpression searchByLike(String searchBy, String searchQuery) {
		if(StringUtils.equals("board_writer", searchBy)) {
			return QBoardFree.boardFree.board_writer.like("%" + searchQuery + "%");
		}else if(StringUtils.equals("board_title", searchBy)){
			return QBoardFree.boardFree.board_title.like("%" + searchQuery + "%");
		}
		return null;
	}
}
