package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BoardFreeReplyBaseEntity {

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member.class) // fk
    @CreatedBy
    @JoinColumn(name = "reply_writer", referencedColumnName = "MId")
    private String reply_writer;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime reply_regdate;
}
