package com.culture.dto.TicketTradeDto;

import com.culture.constant.TradeStatus;
import com.culture.entity.TicketTrade.TicketTrade;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter @Setter
public class TicketTradeDto {
    private Long trade_no;
    private String trade_writer;
    private TradeStatus tradeStatus;
    private String trade_title;
    private String trade_content;
    private LocalDateTime trade_regdate;
    private int trade_readhit;

    private static ModelMapper modelMapper = new ModelMapper();

    public static TicketTradeDto of(TicketTrade ticketTrade){
        return modelMapper.map(ticketTrade, TicketTradeDto.class);
    }
}
