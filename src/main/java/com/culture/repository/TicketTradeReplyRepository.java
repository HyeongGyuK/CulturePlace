package com.culture.repository;

import com.culture.controller.Board.TicketTrade.TicketTradeReplyDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.entity.TicketTrade.TicketTradeReply;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketTradeReplyRepository {
    TicketTradeReply findByTicketTrade(TicketTrade trade_no);

    @Query(" select new com.culture.dto.TicketTradeDto.TicketTradeReplyDto(tt.trade_no, tt.reply_no, ttr.reply_content, tt.trade_writer, tt.trade_regdate) " +
            " from TicketTradeReply ttr, TicketTrade tt" +
            " where tt.trade_no = :trade_no and ttr.ticketTrade = :trade_no" +
            " order by ttr.reply_no desc ")
    List<TicketTradeReplyDto> findByTicketTradeReplyDtoList(Long trade_no);
}
