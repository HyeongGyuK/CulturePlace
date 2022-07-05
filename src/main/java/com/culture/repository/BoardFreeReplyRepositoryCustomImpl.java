//package com.culture.repository;
//
//import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;
//import com.culture.entity.boardFree.BoardFreeReply;
//import com.culture.entity.boardFree.QBoardFreeReply;
//import com.querydsl.core.QueryResults;
//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//// 자유 게시판 글 목록 조회에 대한 interface를 구현하기 위한 클래스 입니다.
//public class BoardFreeReplyRepositoryCustomImpl implements BoardFreeReplyRepositoryCustom{
//
//	private JPAQueryFactory queryFactory; // 질의어 대행
//
//	public BoardFreeReplyRepositoryCustomImpl(EntityManager em) { // BoardFreeRepositoryImpl 본인에 대한 객체화
//		this.queryFactory = new JPAQueryFactory(em);
//	}
//
//	@Override
//	public Page<BoardFreeReply> getBoardFreeReplyPage(Pageable pageable, BoardFreeSearchDto boardFreeSearchDto) {
//		QueryResults<BoardFreeReply> results = this.queryFactory // 페이징에 대한 정보와 데이터 목록을 가지고 있는 객체
//				.selectFrom(QBoardFreeReply.boardFreeReply)
//				.where(searchBoardNo(boardFreeSearchDto.getSearchQuery()))
//				.orderBy(QBoardFreeReply.boardFreeReply.reply_no.asc())
//				.offset(pageable.getOffset())
//				.limit(pageable.getPageSize())
//				.fetchResults();
//
//		List<BoardFreeReply> content = results.getResults();
//		Long total = results.getTotal();
//
//		return new PageImpl<>(content, pageable, total);
//	}
//	private BooleanExpression searchBoardNo(String searchQuery){
//		return QBoardFreeReply.boardFreeReply.boardFree.board_no.eq(Long.valueOf(searchQuery));
//	}
//}
