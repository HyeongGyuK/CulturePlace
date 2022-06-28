package com.culture.service;

import com.culture.entity.BoardReviewImg;
import com.culture.repository.BoardReviewImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardReviewImgService {
    @Value("${boardReviewImgLocation}")
    private String boardReviewImgLocation;

    private final BoardReviewImgRepository boardReviewImgRepository;
    private final FileService fileService;

    private String savedImagePath = "/images/boardReview/";

    public void saveBoardReviewImg(BoardReviewImg boardReviewImg, MultipartFile boardReviewImgFile) throws Exception{
        String oriImgName = boardReviewImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(boardReviewImgLocation, oriImgName, boardReviewImgFile.getBytes());
            imgUrl = savedImagePath + imgName;
        }

        boardReviewImg.updateBoardReviewImg(oriImgName, imgName, imgUrl);

        boardReviewImgRepository.save(boardReviewImg);
    }
}
