package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.NoticeDto;
import com.culture.dto.BoardFreeDto.NoticeWriteDto;
import com.culture.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardFreeNoticeController {

    private final NoticeService noticeService;

    // 공지사항 글 작성 페이지로 이동
    @GetMapping(value = "/admin/CommunityMain/notice_write")
    public String noticeDetail(Model model) {
        model.addAttribute("noticeWriteDto", new NoticeWriteDto());
        return "thymeleaf/Board/BoardFree/notice_write";
    }

    // 공지사항 작성
    @PostMapping(value = "/admin/CommunityMain/notice_write")
    public String noticeWrite(@Valid NoticeWriteDto noticeWriteDto,
                              BindingResult bindingResult,
                              Model model){

        if(bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            Map<String, String> errorMsg = new HashMap<>();

            for (int i = 0; i < list.size(); i++){
                String field = list.get(i).getField();
                String message = list.get(i).getDefaultMessage();

                errorMsg.put(field, message);
            }
            model.addAttribute("errorMessage", errorMsg);

            return "thymeleaf/Board/BoardFree/noitce_write";
        }

        try {

            noticeService.savedNoticeWrite(noticeWriteDto);
        }catch (Exception e) {
            model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
            return "thymeleaf/Board/BoardFree/noitce_write";
        }

        return "redirect:/CommunityMain"; // 자유 게시판 메인 페이지로 이동
    }

    // 공지사항 상세정보
    @GetMapping(value = "/CommunityMain/notice_detail/{notice_no}")
    public String boardFreeDetail(@PathVariable("notice_no") Long notice_no, Model model, Principal principal) {
        NoticeDto noticeDto = noticeService.getNoticeDetail(notice_no);

        String userId = principal.getName();

        // 조회수 증가
        if(!userId.equals(noticeDto.getNotice_writer())){
            model.addAttribute("reahitPlus", noticeService.updatenoticeReadHit(notice_no));
        }

        // Principal = 로그인한 사용자의 정보
        if(principal == null){
            model.addAttribute("noticeDto", noticeDto);
        }else{
            model.addAttribute("userId", userId);
            model.addAttribute("noticeDto", noticeDto);
        }

        return "thymeleaf/Board/BoardFree/notice_detail";
    }

    @GetMapping(value = "/CommunityMain/notice_notice_update")
    public String noticeUpdate(Model model) {
        return "thymeleaf/Board/BoardFree/notice_notice_update";
    }
}
