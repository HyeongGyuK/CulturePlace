package com.culture.dto.TicketTradeDto;

import com.culture.constant.TradeStatus;
import com.culture.entity.TicketTrade.TicketTrade;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class TicketTradeWriteDto {
    private Long trade_no;
    private String trade_writer;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String trade_title;

    @NotBlank(message = "내용은 필수 입력 사항입니다.")
    private String trade_content;

    private TradeStatus tradeStatus;

    private LocalDateTime trade_regdate;

    private static ModelMapper modelMapper = new ModelMapper();

    public TicketTrade ticketTradeWrite(){
        return modelMapper.map(this, TicketTrade.class);
    }

    public static TicketTradeDto of(TicketTrade ticketTrade){
        return modelMapper.map(ticketTrade, TicketTradeDto.class);
    }
}
