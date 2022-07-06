package com.culture.entity.TicketTrade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

@Getter @Setter @ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public class TicketTradeBaseEntity extends TicketTradeBaseTimeEntity{
    @CreatedBy
    @JoinColumn(name = "member_id", referencedColumnName = "MId")
    private String trade_writer;

    @LastModifiedBy
    private String trade_updatedBy;
}
