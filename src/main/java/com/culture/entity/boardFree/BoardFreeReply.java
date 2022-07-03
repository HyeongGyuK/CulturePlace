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

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BoardFree.class) // fk
    @JoinColumn(name = "board_no")
    private Long bNo;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int reply_no; // pk

    @Column(nullable = false)
    private String reply_content;
}
