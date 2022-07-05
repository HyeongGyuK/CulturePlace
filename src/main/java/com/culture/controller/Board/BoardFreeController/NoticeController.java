package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.dto.BoardFreeDto.NoticeDto;
import com.culture.dto.BoardFreeDto.NoticeWriteDto;
import com.culture.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 글 작성 페이지로 이동
    @GetMapping(value = "/admin/CommunityMain/notice_write")
    public String noticeWrite(Model model) {
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
    public String noticeDetail(@PathVariable("notice_no") Long notice_no, Model model, Principal principal) {
        NoticeDto noticeDto = noticeService.getNoticeDetail(notice_no);

        // userId를 담을 변수
        String userId = "";

        // 로그인을 하지 않을 시에 anonymousUser로 값을 반환한다.
        Object who = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String unknown = who.toString();

        // 사용자가 로그인을 하지 않았을 시에는 조회수가 오르지 않는다 또한 게시글의 작성자와 로그인한 사용자의 정보가 불일치 할 시 수정이 불가능하다.
        if(unknown == "anonymousUser"){
            userId = unknown;

            model.addAttribute("userId", userId);
            model.addAttribute("noticeDto", noticeDto);
        }else{
            userId = principal.getName();
            // 조회수 증가
            if(!userId.equals(noticeDto.getNotice_writer())){
                model.addAttribute("readhitPlus", noticeService.updateNoticeReadHit(notice_no));
            }

            model.addAttribute("userId", userId);
            model.addAttribute("noticeDto", noticeDto);
            model.addAttribute("replyWriteDto", new BoardFreeReplyWriteDto());
        }

        return "thymeleaf/Board/BoardFree/notice_detail";
    }

    // 공지사항 수정 폼
    @GetMapping(value = "/admin/CommunityMain/notice_update")
    public String noticeUpdateForm(@RequestParam(value = "notice_no", required = false) Long notice_no, Model model) {

        try{
            NoticeDto noticeDto = noticeService.getNoticeDetail(notice_no);
            model.addAttribute("noticeDto", noticeDto);
        }catch (EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 게시물입니다.");
            model.addAttribute("noticeDto", new NoticeDto());
        }

        return "thymeleaf/Board/BoardFree/notice_update";
    }

    // 공지사항 수정
    @PostMapping(value = "/admin/CommunityMain/notice_update/{notice_no}")
    public String noticeUpdatePost(@Valid NoticeWriteDto noticeWriteDto,
                              BindingResult bindingResult,
                              Model model) throws Exception{

        if(bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            Map<String, String> errorMsg = new HashMap<>();

            for (int i = 0; i < list.size(); i++){
                String field = list.get(i).getField();
                String message = list.get(i).getDefaultMessage();

                errorMsg.put(field, message);
            }
            model.addAttribute("errorMessage", errorMsg);

            return "thymeleaf/Board/BoardFree/notice_update";
        }

        try {
            noticeService.noticeUpdate(noticeWriteDto);
        }catch (Exception e) {
            model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
            return "thymeleaf/Board/BoardFree/notice_update";
        }

        return "redirect:/CommunityMain"; //  자유 게시판 메인 페이지로 이동
    }

    // 공지사항 삭제
    @GetMapping(value = "/admin/CommunityMain/notice_delete")
    public String doNoticeDelete(@RequestParam(value = "notice_no", required = false) Long notice_no) throws Exception{
        if(notice_no == null){
            return "redirect:/CommunityMain";
        }
        noticeService.noticeDelete(notice_no);
        return "redirect:/CommunityMain";
    }
}
