package com.culture.dto.BoardFreeDto;//package com.culture.dto;

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
}