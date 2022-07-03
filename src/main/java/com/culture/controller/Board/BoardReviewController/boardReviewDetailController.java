package com.culture.controller.Board.BoardReviewController;

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
import java.security.Principal;

@Controller
@RequiredArgsConstructor
/*@RequestMapping(value = "/board")*/
public class boardReviewDetailController {

   private final BoardReviewService boardReviewService;

   /* @GetMapping(value = "/review/{bno}")
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
    }*/


    @GetMapping(value = "/review/{bno}")
    public String boardReviewDetail(@PathVariable("bno") Long bno, Model model, Principal principal) {
        BoardReviewDto boardReviewDto = boardReviewService.getBoardReviewDetail(bno);

        String userId = principal.getName();

        // 조회수 증가
        if(!userId.equals(boardReviewDto.getCreate_by())){
            model.addAttribute("reahitPlus", boardReviewService.updateBoardReviewReadHit(bno));
        }

        // Principal = 로그인한 사용자의 정보
        if(principal == null){
            model.addAttribute("boardReview", boardReviewDto);
        }else{
            model.addAttribute("userId", userId);
            model.addAttribute("boardReview", boardReviewDto);
        }

        return "thymeleaf/BoardReview/boardReview_detail";
    }

}
