package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto;
import com.culture.dto.BoardFreeSearchDto;
import com.culture.entity.BoardFree;
import com.culture.service.BoardFreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardFreeController {

	private final BoardFreeService boardFreeService;

	@GetMapping(value = "/BoardFree/board_free_write")
	public String boardForm(Model model) {
		return "thymeleaf/Board/BoardFree/board_free_write";
	}

	// 글 작성
//	@PostMapping(value = "/BoardFree/board_free_write/new")
//	public String boardWrite(@Valid BoardFreeDto boardFreeDto, BindingResult bindingResult, Model model) {
//
//		if(bindingResult.hasErrors()) {
//			return "/Board/BoardFree/board_free_write";
//		}
//
//		if(boardFreeDto.getBoard_title() == null) {
//			model.addAttribute("errorMessage", "제목은 필수 입력 사항입니다.");
//			return "/Board/BoardFree/board_free_write";
//		}
//
//		if(boardFreeDto.getBoard_writer() == null) {
//			model.addAttribute("errorMessage", "내용은 필수 입력 사항입니다.");
//			return "/Culture/Board/BoardFree/board_free_write";
//		}
//
//		try {
//			boardFreeService.savedBoardWrite(boardFreeDto);
//		}catch (Exception e) {
//			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
//			return "/Board/BoardFree/board_free_write";
//		}
//
//		return "redirect:/"; // 메인 페이지로 이동 합니다.
//	}

	// CommunityMain 글 목록 조회
	@GetMapping(value = {"/CommunityMain", "/CommunityMain/{page}"})
	public String boardMain(BoardFreeSearchDto boardFreeSearchDto,
							@PathVariable("page") Optional<Integer> page,
							Model model) {

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);

		Page<BoardFree> boardFreeLists = boardFreeService.getBoardFreePage(boardFreeSearchDto, pageable);

		model.addAttribute("boardFreeLists", boardFreeLists);
		model.addAttribute("boardFreeSearchDto", boardFreeSearchDto);
		model.addAttribute("maxPage", 5);

		return "thymeleaf/Board/BoardFree/board_free_main";
	}

	@GetMapping(value = "/BoardFree/board_free_update")
	public String boardUpdate(Model model) {
		return "thymeleaf/Board/BoardFree/board_free_update";
	}

	// 게시판 상세 정보
	@GetMapping(value = "/BoardFree/board_free_detail/{board_no}")
	public String boardFreeDetail(Model model, @PathVariable("board_no") Long board_no) {

		BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);
		model.addAttribute("boardFree", boardFreeDto);
		return "thymeleaf/Board/BoardFree/board_free_detail";
	}

	@GetMapping(value = "/BoardFree/board_notice_detail")
	public String noticeDetail(Model model) {
		return "thymeleaf/Board/BoardFree/board_notice_detail";
	}

	@GetMapping(value = "/BoardFree/board_notice_update")
	public String noticeUpdate(Model model) {
		return "thymeleaf/Board/BoardFree/board_notice_update";
	}
}
