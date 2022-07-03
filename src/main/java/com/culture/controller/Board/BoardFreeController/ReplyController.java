package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    // 댓글은 디테일 페이지에서 작성을하고 디테일 페이지에서 bNo값으로 조회를 하여 보여준다

    // 댓글 작성
    @PostMapping(value = "/CommunityMain/board_free_reply")
    public String replyWrite(@Valid BoardFreeReplyWriteDto boardFreeReplyWriteDto,
                             BindingResult bindingResult,
                             Model model){
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            Map<String, String> errorMsg = new HashMap<>();

            for (int i = 0; i < list.size(); i++) {
                String field = list.get(i).getField();
                String message = list.get(i).getField();

                errorMsg.put(field, message);
            }
            model.addAttribute("errorMessage", errorMsg);
            return "thymeleaf/Board/BoardFree/board_free_detail";
        }

        try {
            replyService.savedBoardFreeReplyWrite(boardFreeReplyWriteDto);
        }catch (Exception e){
            model.addAttribute("errorMessage", "댓글 등록중 오류가 발생하였습니다.");
            return "thymeleaf/Board/BoardFree/board_free_detail";
        }

        return "thymeleaf/Board/BoardFree/board_free_detail";
    }

}
