package com.culture.controller.Board.BoardReviewController;

import com.culture.dto.BoardReviewDto;
import com.culture.dto.BoardReviewFormDto;
import com.culture.service.BoardReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class boardReviewUpdateController {

    private final BoardReviewService boardReviewService;

    @GetMapping(value = "/review/update/{bno}")
    public String boardReviewUpdateForm(@PathVariable("bno") Long bno, Model model){

        try{
            BoardReviewFormDto boardReviewFormDto = boardReviewService.getBoardReviewDtl(bno);
            BoardReviewDto boardReviewDto = boardReviewService.getBoardReviewDetail(bno);

            model.addAttribute("boardReview", boardReviewDto);
            model.addAttribute("boardReviewForm", boardReviewFormDto);
            model.addAttribute("boardReviewFormDto", boardReviewFormDto);
        }catch (EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 게시물입니다.");
            model.addAttribute("boardReview", new BoardReviewDto());
        }

        return "thymeleaf/boardReview/boardReview_insert";
    }

    @PostMapping(value = "/board/update/{bno}")
    public String boardReviewUpdate(@Valid BoardReviewFormDto boardReviewFormDto,
                                    BindingResult bindingResult,
                                    Model model,
                                    @RequestParam("boardReviewImgFile")List<MultipartFile> boardReviewImgFileList) throws Exception{

        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            Map<String, String> errorMsg = new HashMap<>();

            for(int i = 0; i < list.size(); i++){
                String field = list.get(i).getField();
                String message = list.get(i).getDefaultMessage();

                errorMsg.put(field, message);
            }
            model.addAttribute("errorMessage", errorMsg);

            return "thymeleaf/boardReview/boardReview_update";
        }

        try{
            boardReviewService.boardReviewUpdate(boardReviewFormDto, boardReviewImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage", "리뷰 수정 중에 오류가 발생했습니다.");
            e.printStackTrace();
            return "thymeleaf/boardReview/boardReview_update";
        }

        return "redirect:/board/main";
    }
}
