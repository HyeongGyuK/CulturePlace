package com.culture.controller.Board.BoardFreeController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.culture.dto.BoardFreeDto;
//import com.culture.service.BoardFreeService;
import com.culture.service.BoardFreeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class BoardFreeController {
	
	private final BoardFreeService boardFreeService;
	
	@GetMapping(value = "/BoardFree/board_free_write")
	public String boardForm(Model model) {
		return "Board/BoardFree/board_free_write.jsp";
	}
	
	// 글 작성
	@PostMapping(value = "/BoardFree/board_free_write/new")
	public String boardWrite(@Valid BoardFreeDto boardFreeDto, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "../../../Culture/Board/BoardFree/board_free_write";
		}
		
		if(boardFreeDto.getBoard_title() == null) {
			model.addAttribute("errorMessage", "제목은 필수 입력 사항입니다.");
			return "../../../Culture/Board/BoardFree/board_free_write";
		}
		
		if(boardFreeDto.getBoard_writer() == null) {
			model.addAttribute("errorMessage", "내용은 필수 입력 사항입니다.");
			return "../../../Culture/Board/BoardFree/board_free_write";
		}
		
		try {
			boardFreeService.savedBoardWrite(boardFreeDto);
		}catch (Exception e) {
			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
			return "../../../Culture/Board/BoardFree/board_free_write";
		}
		
		return "redirect:/";
	}
	
	
	// 글 목록 조회
//	@GetMapping(value = {"/BoardFree/board_free_main", "/BoardFree/board_free_main/{page}"})
//	public String boardMain(BoardFreeSearchDto boardFreeSearchDto, @PathVariable("page") Optional<Integer> page, Model model) {
//		Pageable pageable = PageRequest.of(page.isPresent() ? page.get(): 0, 10);
//		
//		Page<BoardFree> boardFreeLists = boardFreeService.getBoardFreePage(boardFreeSearchDto, pageable);
//		
//		model.addAttribute("boardFreeLists", boardFreeLists);
//		model.addAttribute("boardFreeSearchDto", boardFreeSearchDto);
//		model.addAttribute("maxPage", 5);
//		
//		return "Board/BoardFree/board_free_main";
//	}
	
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
