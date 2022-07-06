package com.culture.entity.TicketTrade;

import com.culture.constant.TradeStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "ticketTrade")
public class TicketTrade extends TicketTradeBaseEntity{
    @Id
    @Column(name = "trade_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_seq")
    private Long trade_no;

    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;

    @Column(nullable = false, length = 30)
    private String trade_title;

    @Column(nullable = false)
    private String trade_content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int trade_readhit;


}
