package com.culture.controller.Board.BoardReviewController;

import com.culture.dto.BoardFreeDto.BoardFreeDto;
import com.culture.dto.BoardReviewDto;
import com.culture.dto.BoardReviewFormDto;
import com.culture.service.BoardReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class boardReviewDetailController {

    private final BoardReviewService boardReviewService;

    @GetMapping(value = "/detail/{bno}")
    public String boardReviewDetailForm(@PathVariable("bno") Long bno, Model model){

        BoardReviewDto boardReviewDto = boardReviewService.getBoardReviewDetail(bno);
        BoardReviewFormDto boardReviewFormDto = boardReviewService.getBoardReviewDtl(bno);
        try{
            model.addAttribute("boardReview", boardReviewDto);
            model.addAttribute("boardReviewForm", boardReviewFormDto);
        }catch (EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 게시글입니다.");
            model.addAttribute("boardReview", boardReviewDto);
            model.addAttribute("boardReviewForm", boardReviewFormDto);
        }

        return "thymeleaf/boardReview/boardReview_detail";
    }
}
