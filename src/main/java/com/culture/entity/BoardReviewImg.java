package com.culture.entity;

import javax.persistence.*;

public class BoardReviewImg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String imgName ; // UUID 형식으로 업로드된 이미지 파일 이름
    private String oriImgName ; // 이미지 원본 이름
    private String imgUrl ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardReivew_b_no")
    private BoardReview boardReview ;

    // 이미지 정보를 업데이트 해주는 메소드
    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName ;
        this.imgName = imgName ;
        this.imgUrl = imgUrl ;
    }
}
