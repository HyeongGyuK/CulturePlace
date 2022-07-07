package com.culture.dto.TicketTradeDto;

import com.culture.entity.TicketTrade.TicketTradeReply;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class TicketTradeReplyWriteDto {
    private Long board_no;
    private int reply_no;

    @NotBlank(message = "댓글의 내용을 입력하여 주세요.")
    private String reply_content;
    private String reply_writer;
    private LocalDateTime reply_regdate;

    private ModelMapper modelMapper = new ModelMapper();

    public TicketTradeReply replyWrite() {
        return modelMapper.map(this, TicketTradeReply.class);
    }
}
