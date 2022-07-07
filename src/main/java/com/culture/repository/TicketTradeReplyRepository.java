package com.culture.repository;

import com.culture.controller.Board.TicketTrade.TicketTradeReplyDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.entity.TicketTrade.TicketTradeReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TicketTradeReplyRepository extends JpaRepository<TicketTradeReply, Long>,
        QuerydslPredicateExecutor<TicketTradeReply> {
    TicketTradeReply findByTicketTrade(TicketTrade trade_no);

    @Query(" select new com.culture.dto.TicketTradeDto.TicketTradeReplyDto(tt.trade_no, ttr.reply_no, ttr.reply_content, ttr.reply_writer, ttr.reply_regdate) " +
            " from TicketTradeReply ttr, TicketTrade tt" +
            " where tt.trade_no = :trade_no and ttr.ticketTrade = :trade_no" +
            " order by ttr.reply_no desc ")
    List<TicketTradeReplyDto> findByTicketTradeReplyDtoList(Long trade_no);
}
