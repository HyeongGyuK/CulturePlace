package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeDto;
import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;
import com.culture.dto.BoardFreeDto.BoardFreeWriteDto;
import com.culture.entity.boardFree.BoardFree;
import com.culture.service.BoardFreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller("CommunityMain")
@RequiredArgsConstructor
public class BoardFreeController {

	private final BoardFreeService boardFreeService;

	@GetMapping(value = "/CommunityMain/board_free_write")
	public String boardForm(Model model) {
		model.addAttribute("boardFreeWriteDto", new BoardFreeWriteDto());
		return "thymeleaf/Board/BoardFree/board_free_write";
	}

	// 글 작성
	@PostMapping(value = "/CommunityMain/board_free_write")
	public String boardWrite(@Valid BoardFreeWriteDto boardFreeWriteDto,
							 BindingResult bindingResult,
							 Model model) {

		if(bindingResult.hasErrors()) {
			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<>();

			for (int i = 0; i < list.size(); i++){
				String field = list.get(i).getField();
				String message = list.get(i).getDefaultMessage();

				errorMsg.put(field, message);
			}
			model.addAttribute("errorMessage", errorMsg);

			return "thymeleaf/Board/BoardFree/board_free_write";
		}

		if(boardFreeWriteDto.getBoard_title() == null) {
			model.addAttribute("errorMessage", "제목은 필수 입력 사항입니다.");
			return "thymeleaf/Board/BoardFree/board_free_write";
		}

		if(boardFreeWriteDto.getBoard_content() == null) {
			model.addAttribute("errorMessage", "내용은 필수 입력 사항입니다.");
			return "thymeleaf/Board/BoardFree/board_free_write";
		}

		try {
			boardFreeService.savedBoardFreeWrite(boardFreeWriteDto);
		}catch (Exception e) {
			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
			return "thymeleaf/Board/BoardFree/board_free_write";
		}

		return "redirect:/"; // 자유 게시판 메인 페이지로 이동
	}

	// CommunityMain의 전체  글 목록 출력
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

	@GetMapping(value = "/CommunityMain/board_free_update")
	public String boardUpdate(Model model) {
		return "thymeleaf/Board/BoardFree/board_free_update";
	}

	// 게시판 상세 정보
	@GetMapping(value = "/CommunityMain/board_free_detail/{board_no}")
	public String boardFreeDetail(Model model, @PathVariable("board_no") Long board_no) {

		BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);
		model.addAttribute("boardFree", boardFreeDto);
		return "thymeleaf/Board/BoardFree/board_free_detail";
	}

	@GetMapping(value = "/CommunityMain/board_notice_detail")
	public String noticeDetail(Model model) {
		return "thymeleaf/Board/BoardFree/board_notice_detail";
	}

	@GetMapping(value = "/CommunityMain/board_notice_update")
	public String noticeUpdate(Model model) {
		return "thymeleaf/Board/BoardFree/board_notice_update";
	}

}
