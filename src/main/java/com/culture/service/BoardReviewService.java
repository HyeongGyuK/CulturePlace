package com.culture.service;

import com.culture.dto.BoardReviewDto;
import com.culture.dto.BoardReviewFormDto;
import com.culture.dto.BoardReviewImgDto;
import com.culture.dto.MainBoardReviewDto;
import com.culture.entity.BoardReview;
import com.culture.entity.BoardReviewImg;
import com.culture.repository.BoardReviewImgRepository;
import com.culture.repository.BoardReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardReviewService {
    private final BoardReviewRepository boardReviewRepository;
    private final BoardReviewImgService boardReviewImgService;

    public Long saveBoardReview(BoardReviewFormDto boardReviewFormDto, List<MultipartFile> boardReviewImgFileList) throws Exception{
        // 리뷰 등록 화면에서 넘어온 데이터를 이용하여 BoardReview Entity를 생성합니다.
        BoardReview boardReview = boardReviewFormDto.insertBoardReview();
        boardReviewRepository.save(boardReview); // 리뷰 데이터 저장

        // 리뷰에 들어가는 각 이미지 등록
        for(int i = 0; i < boardReviewImgFileList.size(); i++){
            BoardReviewImg boardReviewImg = new BoardReviewImg();

            boardReviewImg.setBoardReview(boardReview);

            boardReviewImgService.saveBoardReviewImg(boardReviewImg, boardReviewImgFileList.get(i));
        }

        System.out.println("boardReviewService saveBoardReview");

        return boardReview.getBno();
    }

    private final BoardReviewImgRepository boardReviewImgRepository;

    @Transactional(readOnly = true)
    public BoardReviewFormDto getBoardReviewDtl(Long boardReviewId){
        List<BoardReviewImg> boardReviewImgList = boardReviewImgRepository.findByBoardReviewBnoOrderByBnoAsc(boardReviewId);

        List<BoardReviewImgDto> boardReviewImgDtoList = new ArrayList<BoardReviewImgDto>();

        for(BoardReviewImg boardReviewImg : boardReviewImgList){
            BoardReviewImgDto boardReviewImgDto = BoardReviewImgDto.of(boardReviewImg);
            boardReviewImgDtoList.add(boardReviewImgDto);
        }

        BoardReview boardReview = boardReviewRepository.findById(boardReviewId)
                .orElseThrow(EntityNotFoundException::new);
        BoardReviewFormDto boardReviewFormDto = BoardReviewFormDto.of(boardReview);
        boardReviewFormDto.setBoardReviewImgDtoList(boardReviewImgDtoList);

        return boardReviewFormDto;
    }

    @Transactional(readOnly = true)
    public Page<BoardReview> getAdminBoardReviewPage(Pageable pageable){
        return boardReviewRepository.getAdminBoardReviewPage(pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainBoardReviewDto> getMainBoardReviewPage(Pageable pageable){
        return boardReviewRepository.getMainBoardReviewPage(pageable);
    }

    public BoardReviewDto getBoardReviewDetail(Long bno){
        BoardReview boardReview = boardReviewRepository.findById(bno).orElseThrow(EntityNotFoundException::new);

        BoardReviewDto boardReviewDto = BoardReviewDto.of(boardReview);

        return boardReviewDto;
    }
}































