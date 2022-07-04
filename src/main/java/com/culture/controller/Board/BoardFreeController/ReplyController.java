package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    // 댓글은 디테일 페이지에서 작성을하고 디테일 페이지에서 bNo값으로 조회를 하여 보여준다

    // 댓글 작성
    @PostMapping(value = "/CommunityMain/board_free_detail/reply/{board_no}")
    public String replyWrite(@Valid BoardFreeReplyWriteDto boardFreeReplyWriteDto,
                             BindingResult bindingResult,
                             Model model, Principal principal) throws Exception {

        replyService.savedBoardFreeReplyWrite(boardFreeReplyWriteDto);

        return "redirect:/CommunityMain/board_free_detail/{board_no}";
    }

}
