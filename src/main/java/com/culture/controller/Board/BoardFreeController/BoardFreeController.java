package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.BoardFreeDto;
import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;
import com.culture.dto.BoardFreeDto.BoardFreeWriteDto;
import com.culture.dto.BoardFreeDto.NoticeDto;
import com.culture.entity.boardFree.BoardFree;
import com.culture.service.BoardFreeService;
import com.culture.service.NoticeService;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardFreeController {

	private final BoardFreeService boardFreeService;
	private final NoticeService noticeService;

	// 글 작성 페이지로 이동
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

		try {

			boardFreeService.savedBoardFreeWrite(boardFreeWriteDto);
		}catch (Exception e) {
			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
			return "thymeleaf/Board/BoardFree/board_free_write";
		}

		return "redirect:/CommunityMain"; // 자유 게시판 메인 페이지로 이동
	}

	// CommunityMain의 전체  글 목록 출력
	@GetMapping(value = {"/CommunityMain", "/CommunityMain/{page}"})
	public String boardMain(BoardFreeSearchDto boardFreeSearchDto,
							@PathVariable("page")Optional<Integer> page,
							Model model) {

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);

		Page<BoardFree> boardFreeLists = boardFreeService.getBoardFreePage(boardFreeSearchDto, pageable);

		model.addAttribute("boardFreeLists", boardFreeLists);
		model.addAttribute("boardFreeSearchDto", boardFreeSearchDto);
		model.addAttribute("maxPage", 5);


		Page<NoticeDto> noticeDto = noticeService.getNoticePage(pageable);

		model.addAttribute("noticeDto", noticeDto);
		model.addAttribute("maxPage", 5);

		return "thymeleaf/Board/BoardFree/board_free_main";
	}

	// 게시판 상세 정보
	@GetMapping(value = "/CommunityMain/board_free_detail/{board_no}")
	public String boardFreeDetail(@PathVariable("board_no") Long board_no, Model model, Principal principal) {
		BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);

		String userId = principal.getName();

		// 조회수 증가
		if(!userId.equals(boardFreeDto.getBoard_writer())){
			model.addAttribute("reahitPlus", boardFreeService.updateBoardFreeReadHit(board_no));
		}

		// Principal = 로그인한 사용자의 정보
		if(principal == null){
			model.addAttribute("boardFree", boardFreeDto);
		}else{
			model.addAttribute("userId", userId);
			model.addAttribute("boardFree", boardFreeDto);
		}

		return "thymeleaf/Board/BoardFree/board_free_detail";
	}

	// 게시판 수정 폼으로 가기
	@GetMapping(value = "/CommunityMain/board_free_update")
	public String boardUpdateForm(@RequestParam(value = "board_no", required = false) Long board_no, Model model) {


		boardFreeService.updateBoardFreeReadHit(board_no); // board_readhit ++

		try{
			BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);
			model.addAttribute("boardFree", boardFreeDto);
		}catch (EntityNotFoundException e){
			model.addAttribute("errorMessage", "존재하지 않는 게시물입니다.");
			model.addAttribute("boardFreeDto", new BoardFreeDto());
		}


		return "thymeleaf/Board/BoardFree/board_free_update";
	}

	// 게시판 수정 post로 갱신
	@PostMapping(value = "/CommunityMain/board_free_update/{board_no}")
	public String boardUpdate(@Valid BoardFreeWriteDto boardFreeWriteDto,
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

			return "thymeleaf/Board/BoardFree/board_free_update";
		}

		try {
			boardFreeService.boardFreeUpdate(boardFreeWriteDto);
		}catch (Exception e) {
			model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
			return "thymeleaf/Board/BoardFree/board_free_update";
		}

		return "redirect:/CommunityMain"; // 자유 게시판 메인 페이지로 이동
	}

	// 게시글 삭제 기능
	@GetMapping(value = "/CommunityMain/board_free_delete")
	public String doBoardFreeDelete(@RequestParam(value = "board_no", required = false) Long board_no) throws Exception{
		if(board_no == null){
			return "redirect:/CommunityMain";
		}
		boardFreeService.boardFreeDelete(board_no);
		return "redirect:/CommunityMain";
	}
}
