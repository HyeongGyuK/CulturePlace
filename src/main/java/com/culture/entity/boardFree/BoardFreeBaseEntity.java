package com.culture.entity.boardFree;

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
public abstract class BoardFreeBaseEntity extends BoardFreeBaseTimeEntity{

    // 생성한 사람
//    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    @JoinColumn(name = "member_id", referencedColumnName = "MId")
    private String board_writer; // 작성자

    // 수정자
    @LastModifiedBy
    private String board_updatedBy;
}
