package com.culture.controller.Board.BoardFreeController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.culture.dto.BoardFreeDto;
//import com.culture.service.BoardFreeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class BoardFreeController {
	
//	private final BoardFreeService boardFreeService;
	
//	private final BoardFreeService boardFreeService;
	
	@GetMapping(value = "/BoardFree/board_free_write")
	public String boardForm(Model model) {
		return "Board/BoardFree/board_free_write.jsp";
	}
	
	@PostMapping(value = "/BoardFree/board_free_write/board_write")
	public String boardWrite(@Valid BoardFreeDto boardFreeDto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "Board/BoardFree/board_free_write.jsp";
		}
		
		try {
//			boardFreeService.savedBoardWrite(boardFreeDto);
		}catch (Exception e) {
			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
			return "Board/BoardFree/board_free_write.jsp";
		}
		
		return "redirect:/";
	}
	
	
	// 전체 글 목록 조회
	@GetMapping(value = "/BoardFree/board_free_main")
	public String boardMain(Model model) {
//		List<BoardFreeDto> boardFreeList = boardFreeService.getBoardFreeList();
		
		return "Board/BoardFree/board_free_main.jsp";
	}
	
	@GetMapping(value = "/BoardFree/board_free_update")
	public String boardUpdate(Model model) {
		return "Board/BoardFree/board_free_update.jsp";
	}
	
	@GetMapping(value = "/BoardFree/board_free_detail")
	public String boardDetail(Model model) {
		return "Board/BoardFree/board_free_detail.jsp";
	}
	
	@GetMapping(value = "/BoardFree/board_notice_detail")
	public String noticeDetail(Model model) {
		return "Board/BoardFree/board_notice_detail.jsp";
	}
	
	@GetMapping(value = "/BoardFree/board_notice_update")
	public String noticeUpdate(Model model) {
		return "Board/BoardFree/board_notice_update.jsp";
	}
}
