package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name = "boardFreeReply")
@Entity
//public class BoardFreeReply {
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "")
//    private Long ; // forgin key : 글 번호
//
//    @JoinColumn(name = "")
//    private String reply_writer;
//
//    private String reply_content;
}
