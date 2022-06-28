package com.culture.entity.boardFree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BoardFreeBaseTimeEntity {
    // 생성 날짜
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime board_regdate; // 작성 일자

    // 수정 날짜
    @LastModifiedDate
    private LocalDateTime board_updateTime;
}
