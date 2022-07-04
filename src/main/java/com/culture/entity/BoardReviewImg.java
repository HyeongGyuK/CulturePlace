package com.culture.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "boardReview_img")
@Getter @Setter
public class BoardReviewImg extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "review_seq")
    private Long bno ;
    private String imgName ; // UUID 형식으로 업로드된 이미지 파일 이름
    private String oriImgName ; // 이미지 원본 이름
    private String imgUrl ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardReivew_bno")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BoardReview boardReview ;

    // 이미지 정보를 업데이트 해주는 메소드
    public void updateBoardReviewImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName ;
        this.imgName = imgName ;
        this.imgUrl = imgUrl ;
    }
}
