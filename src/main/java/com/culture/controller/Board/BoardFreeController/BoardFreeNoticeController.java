package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardFreeNoticeController {

    @GetMapping(value = "/admin/CommunityMain/notice_write")
    public String noticeDetail(Model model) {
        model.addAttribute("noticeWriteDto", new BoardFreeWriteDto());
        return "thymeleaf/Board/BoardFree/notice_write";
    }

    @GetMapping(value = "/CommunityMain/board_notice_update")
    public String noticeUpdate(Model model) {
        return "thymeleaf/Board/BoardFree/board_notice_update";
    }
}
