package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter @Setter @ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BoardFreeReplyBaseEntity {

    @CreatedBy
    @JoinColumn(name = "MId")
    private String reply_writer;

    @CreatedDate
    @Column(nullable = false)
    private int reply_regdate;
}
