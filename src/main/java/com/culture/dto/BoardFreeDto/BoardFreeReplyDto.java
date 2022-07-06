package com.culture.dto.BoardFreeDto;//package com.culture.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardFreeReplyDto {
    private Long board_no;
    private Long reply_no;
    private String reply_content;
    private String reply_writer;
    private LocalDateTime reply_regdate;

    @QueryProjection
    public BoardFreeReplyDto(Long board_no, Long reply_no, String reply_content, String reply_writer, LocalDateTime reply_regdate){
        this.board_no = board_no;
        this.reply_no = reply_no;
        this.reply_content = reply_content;
        this.reply_writer = reply_writer;
        this.reply_regdate = reply_regdate;
    }
}