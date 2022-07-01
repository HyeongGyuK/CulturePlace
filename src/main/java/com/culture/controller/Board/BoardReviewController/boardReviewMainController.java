package com.culture.controller.Board.BoardReviewController;

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


	//p234 목록조회
	// {"/admin/items", "/admin/items/{page}"} -> "/admin/items/{page}" 페이지가 들어갈수도 안들어갈수도 있음. 변수가 여러개임으로 배열{}형태로 작성함
//   @GetMapping(value = {"/board/main", "/board/main/{page}"})// {page}(자바의 매개변수)에 3이 들어가면 3페이지보여주세요
//   public String reviewManage(
//         @PathVariable("page") Optional<Integer> page, //for {page}. 옵션으로 특정페이지를 넣을수도 안넣을수도.
//         // 자바의 Integer page = request.getParameter("page").
//         // Optional: page에 아무것도 안들어가면->nullPointerException(NPE)방지하기위해 자바에서 자체적으로 만든것이 optional.
//         // "page" = 파라미터명, page: 변수명
//         Model model){ //for 바인딩(모델=빈=데이터)
//
//      Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,6);
//      //page.isPresent() ? page.get() : 0 -> 삼항연산자. page가 존재하면 page를get하고 아니면 0.
//
//      Page<BoardReview> reviews = boardReviewService.getAdminBoardReviewPage(pageable);
//
//      //데이터를 묶는것은 바인딩. 바인딩은 모델객체.
//      model.addAttribute("reviews",reviews);
//      model.addAttribute("maxPage",5); //하단에 보여줄 페이지번호의 최대갯수
//
//      return "board/reviewMng";
//   }

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

}


