package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name = "boardFreeReply")
@Entity
public class BoardFreeReply extends BoardFreeReplyBaseEntity{

    @Id
    @JoinColumn(name = "board_no")
    private Long bNo; // forgin key : 글 번호

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int reply_no;

    @Column(nullable = false)
    private String reply_content;
}
