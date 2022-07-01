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

    @QueryProjection
    public NoticeDto(Long notice_no, String notice_title, String notice_content, String notice_writer, LocalDateTime notice_regdate, LocalDateTime notice_updateTime){
        this.notice_no = notice_no;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_writer = notice_writer;
        this.notice_regdate = notice_regdate;
        this.notice_updateTime = notice_updateTime;
    }
}
