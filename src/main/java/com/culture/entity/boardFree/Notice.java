//package com.culture.entity.boardFree;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "notice")
//@Getter @Setter
//@ToString
//@EntityListeners(value = {AuditingEntityListener.class})
//@MappedSuperclass
//public class Notice{
//    @Id
//    @Column(name = "notice_no")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long notice_no;
//
//    @Column(nullable = false)
//    private String notice_title;
//
//    @Column(nullable = false)
//    private String notice_content;
//
//    @JoinColumn(name = "MId")
//    private String notice_writer;
//
//    @CreatedDate
//    @Column(nullable = false)
//    private LocalDateTime notice_regdate;
//
//    @LastModifiedDate
//    private LocalDateTime notice_updateTime;
//}
