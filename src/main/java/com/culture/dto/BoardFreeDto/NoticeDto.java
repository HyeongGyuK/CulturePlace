package com.culture.dto.BoardFreeDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class NoticeDto {
    private Long notice_no;
    private String notice_title;
    private String notice_content;
    private String notice_writer;
    private LocalDateTime notice_regdate;
    private LocalDateTime notice_updateTime;
}
