package com.culture.controller.Board.BoardReviewController;

import com.culture.service.BoardReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class boardReviewDeleteController {
    private final BoardReviewService boardReviewService;
    @GetMapping(value = "/review/delete/{bno}")
    public String boardReviewDelete(@PathVariable("bno") Long bno) throws Exception{
        if(bno == null){
            return "redirect:/board/main";
        }

        boardReviewService.boardReviewDelete(bno);
        return "redirect:/board/main";
    }
}
