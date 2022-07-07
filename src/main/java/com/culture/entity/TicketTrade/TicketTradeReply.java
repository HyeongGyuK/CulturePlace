package com.culture.entity.TicketTrade;

import com.culture.entity.boardFree.BoardFreeReplyBaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@Table(name = "ticketTradeReply")
@Entity
public class TicketTradeReply extends BoardFreeReplyBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TicketTrade.class) // fk
    @JoinColumn(name = "trade_no", referencedColumnName = "trade_no")
    private TicketTrade ticketTrade;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_trade_reply_seq")
    private Long reply_no; // pk

    @Column(nullable = false)
    private String reply_content;
}
