package com.culture.controller.Board.BoardFreeController;

import com.culture.dto.BoardFreeDto.*;
import com.culture.entity.boardFree.BoardFree;
import com.culture.entity.boardFree.Notice;
import com.culture.service.BoardFreeService;
import com.culture.service.NoticeService;
import com.culture.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardFreeController {

	private final BoardFreeService boardFreeService;
	private final NoticeService noticeService;

	private final ReplyService replyService;

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
	@GetMapping(value = {"/CommunityMain", "/CommunityMain/{page}", "/CommunityMain/notice/{pageOfNotice}"})
	public String boardMain(BoardFreeSearchDto boardFreeSearchDto,
							@PathVariable("page")Optional<Integer> page,
							@PathVariable("pageOfNotice")Optional<Integer> pageOfNotice,
							Model model) {

		// 자유게시판 페이징 및 리스트 출력
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);

		Page<BoardFree> boardFreeLists = boardFreeService.getBoardFreePage(boardFreeSearchDto, pageable);

		model.addAttribute("boardFreeLists", boardFreeLists);
		model.addAttribute("boardFreeSearchDto", boardFreeSearchDto);
		model.addAttribute("maxPage", 5);

		// 공지사항 페이징 및 리스트 출력
		Pageable NoticePageable = PageRequest.of(pageOfNotice.isPresent() ? pageOfNotice.get() : 0, 3);

		Page<Notice> noticeDto = noticeService.getNoticePage(NoticePageable);

		model.addAttribute("noticeDto", noticeDto);
		model.addAttribute("maxPage", 5);

		return "thymeleaf/Board/BoardFree/board_free_main";
	}

	// 게시판 상세 정보
	@GetMapping(value = "/CommunityMain/board_free_detail/{board_no}")
	public String boardFreeDetail(BoardFreeReplyDto boardFreeReplyDto,
								  @PathVariable("board_no") Long board_no,
								  Model model, Principal principal) {
		BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);

		List<BoardFreeReplyDto> boardFreeReplyPage = replyService.getReplyPage(board_no);

//		System.out.println("뽑아온 자료 : " + boardFreeReplyPage);

		// userId를 담을 변수
		String userId = "";

		// 로그인을 하지 않을 시에 anonymousUser로 값을 반환한다.
		Object who = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String unknown = who.toString();

		// 사용자가 로그인을 하지 않았을 시에는 조회수가 오르지 않는다 또한 게시글의 작성자와 로그인한 사용자의 정보가 불일치 할 시 수정이 불가능하다.
		if(unknown == "anonymousUser"){
			userId = unknown;

			model.addAttribute("userId", userId);
			model.addAttribute("boardFree", boardFreeDto);

			// 댓글 출력
			model.addAttribute("replyLists", boardFreeReplyPage);
		}else{
			userId = principal.getName();

			// 조회수 증가
			if(!userId.equals(boardFreeDto.getBoard_writer())){
				model.addAttribute("readhitPlus", boardFreeService.updateBoardFreeReadHit(board_no));
			}

			model.addAttribute("userId", userId);
			model.addAttribute("boardFree", boardFreeDto);

			System.out.println(boardFreeReplyPage + "================================");

			// 댓글 출력
			model.addAttribute("replyLists", boardFreeReplyPage);
			// 댓글 작성
			model.addAttribute("replyWriteDto", new BoardFreeReplyWriteDto());
		}

		return "thymeleaf/Board/BoardFree/board_free_detail";
	}

	// 게시판 수정 폼
	@GetMapping(value = "/CommunityMain/board_free_update")
	public String boardUpdateForm(@RequestParam(value = "board_no", required = false) Long board_no, Model model) {

		try{
			BoardFreeDto boardFreeDto = boardFreeService.getBoardDetail(board_no);
			model.addAttribute("boardFree", boardFreeDto);
		}catch (EntityNotFoundException e){
			model.addAttribute("errorMessage", "존재하지 않는 게시물입니다.");
			model.addAttribute("boardFree", new BoardFreeDto());
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
