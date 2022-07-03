package com.culture.service;

import com.culture.entity.BoardReviewImg;
import com.culture.repository.BoardReviewImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardReviewImgService {
    @Value("${boardReviewImgLocation}")
    private String boardReviewImgLocation;

    private final BoardReviewImgRepository boardReviewImgRepository;
    private final FileService fileService;

    private String savedImagePath = "/images/review/";

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

    public void updateBoardReviewImg(Long boardReviewImgId, MultipartFile boardReviewImgFile) throws Exception{
        if(!boardReviewImgFile.isEmpty()){
            BoardReviewImg savedBoardReviewImg = boardReviewImgRepository.findById(boardReviewImgId)
                    .orElseThrow(EntityNotFoundException::new);

            if(!StringUtils.isEmpty(savedBoardReviewImg.getImgName())){
                fileService.deleteFile(boardReviewImgLocation + "/" + savedBoardReviewImg.getImgName());
            }

            String oriImgName = boardReviewImgFile.getOriginalFilename();

            String imgName = fileService.uploadFile(boardReviewImgLocation, oriImgName, boardReviewImgFile.getBytes());
            String imgUrl = savedImagePath + imgName;

            savedBoardReviewImg.updateBoardReviewImg(oriImgName, imgName, imgUrl);
        }
    }
}
