package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public class NoticeBaseEntity {
    @JoinColumn(name = "MId")
    private String notice_writer;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime notice_regdate;

    @LastModifiedDate
    private LocalDateTime notice_updateTime;
}
