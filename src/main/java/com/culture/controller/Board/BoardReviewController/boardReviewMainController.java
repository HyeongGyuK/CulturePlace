package com.culture.controller.Board.BoardReviewController;

import com.culture.constant.CategoryStatus;
import com.culture.dto.BoardFreeDto.BoardFreeDto;
import com.culture.dto.BoardReviewDto;
import com.culture.dto.BoardReviewMainDto;
import com.culture.entity.BoardReview;
import com.culture.service.BoardReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class boardReviewMainController {

	private final BoardReviewService boardReviewService ;

/*
   @GetMapping(value = "/main")
   public String reviewDetail() {
      return "thymeleaf/boardReview/boardReview_main";
   }
*/

	@GetMapping(value = {"/review/main/{category}", "/review/main/{category}/{page}"})
	public String BoardReviewCategory(@PathVariable("category") CategoryStatus categoryStatus, @PathVariable("page") Optional<Integer> page, Model model){
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);

		Page<BoardReviewMainDto> boardReviewDto = boardReviewService.getMainCategoryReviewPage(pageable, categoryStatus);
		Page<BoardReview> reviewLists = boardReviewService.getAdminCategoryBoardReviewPage(pageable, categoryStatus);

		model.addAttribute("boardReviewDto", boardReviewDto) ;
		model.addAttribute("reviewLists", reviewLists) ;
		model.addAttribute("maxPage", 5) ;
		return "thymeleaf/boardReview/boardReview_main";
	}

	//리뷰게시판 메인 및 페이징 구현
	@GetMapping(value = {"/board/main", "/board/main/{page}"})
	public String main(
			@PathVariable("page") Optional<Integer> page,
			Model model){

		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6) ;

		Page<BoardReviewMainDto> boardReviewDto = boardReviewService.getMainBoardReviewPage(pageable) ;
		Page<BoardReview> reviewLists = boardReviewService.getAdminBoardReviewPage(pageable) ;

//        System.out.println("items == null");
//        System.out.println(items == null);
//        System.out.println(itemSearchDto);

		model.addAttribute("boardReviewDto", boardReviewDto) ;
		model.addAttribute("reviewLists", reviewLists) ;
		model.addAttribute("maxPage", 5) ;
		return "thymeleaf/boardReview/boardReview_main";
	}
/*// 게시판 상세 정보 a th:href="'/CommunityMain/board_free_detail/' + ${boardFree.board_no}"
	@GetMapping(value = "/CommunityMain/board_free_detail/{board_no}") */

	// 메인 화면에서 이미지를 클릭하면 상세 페이지로 이동 "'/review/' +${review.bno}"
//	@GetMapping(value = "/review/{bno}")
//	public String boardReviewDetail(@PathVariable("bno") Long bno, Model model, Principal principal) {
//		BoardReviewDto boardReviewDto = boardReviewService.getBoardReviewDetail(bno);
//
//		String userId = principal.getName();
//
//		// 조회수 증가
//		if(!userId.equals(boardReviewDto.getCreate_by())){
//			model.addAttribute("reahitPlus", boardReviewService.updateBoardReviewReadHit(bno));
//		}
//
//		// Principal = 로그인한 사용자의 정보
//		if(principal == null){
//			model.addAttribute("boardReview", boardReviewDto);
//		}else{
//			model.addAttribute("userId", userId);
//			model.addAttribute("boardReview", boardReviewDto);
//		}
//
//		return "thymeleaf/BoardReview/boardReview_detail";
//	}

}


