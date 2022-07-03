package com.culture.entity.boardFree;

import com.culture.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BoardFreeReplyBaseEntity {

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member.class) // fk
    @JoinColumn(name = "MId")
    private String reply_writer;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime reply_regdate;
}
