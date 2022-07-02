package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "notice")
@Getter @Setter
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
}
