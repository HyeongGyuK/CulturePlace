package com.culture.controller.Board.TicketTrade;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TicketTradeReplyDto {
    private Long trade_no;
    private Long reply_no;
    private String reply_content;
    private String reply_writer;
    private LocalDateTime reply_regdate;

    @QueryProjection
    public TicketTradeReplyDto(Long trade_no, Long reply_no, String reply_content, String reply_writer, LocalDateTime reply_regdate){
        this.trade_no = trade_no;
        this.reply_no = reply_no;
        this.reply_content = reply_content;
        this.reply_writer = reply_writer;
        this.reply_regdate = reply_regdate;
    }
}
