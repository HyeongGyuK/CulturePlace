package com.culture.entity.boardFree;

import com.culture.dto.BoardFreeDto.NoticeWriteDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notice")
@Getter @Setter
@ToString
public class Notice extends NoticeBaseEntity{
    @Id
    @Column(name = "notice_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long notice_no;

    @Column(nullable = false)
    private String notice_title;

    @Column(nullable = false)
    private String notice_content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int notice_readhit;

    public void updateNotice(NoticeWriteDto noticeWriteDto) {
        this.notice_title = notice_title;
        this.notice_content = notice_content;
    }
}
