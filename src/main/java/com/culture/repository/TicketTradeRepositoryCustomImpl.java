package com.culture.repository;

import com.culture.constant.TradeStatus;
import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.entity.TicketTrade.QTicketTrade;
import com.culture.entity.TicketTrade.TicketTrade;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketTradeRepositoryCustomImpl implements TicketTradeRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public TicketTradeRepositoryCustomImpl (EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<TicketTrade> getTicketTradePage(TicketTradeSearchDto ticketTradeSearchDto, Pageable pageable) {
        QueryResults<TicketTrade> results = this.queryFactory // 페이징에 대한 정보와 데이터 목록을 가지고 있는 객체
                .selectFrom(QTicketTrade.ticketTrade)
                .where(tradeStatusEq(ticketTradeSearchDto.getSearchTradeStatus()),
                        searchByLike(ticketTradeSearchDto.getSearchBy(), ticketTradeSearchDto.getSearchQuery()))
                .orderBy(QTicketTrade.ticketTrade.trade_no.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<TicketTrade> content = results.getResults();
        Long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression tradeStatusEq(TradeStatus tradeStatus) {
        // 4가지 중에서 택일 : 거래전체, 구매중, 판매중, 거래완료
        return tradeStatus == null ? null : QTicketTrade.ticketTrade.tradeStatus.eq(tradeStatus);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        if(StringUtils.equals("trade_writer", searchBy)) {
            return QTicketTrade.ticketTrade.trade_writer.like("%" + searchQuery + "%");
        }else if(StringUtils.equals("trade_title", searchBy)){
            return QTicketTrade.ticketTrade.trade_title.like("%" + searchQuery + "%");
        }
        return null;
    }
}
