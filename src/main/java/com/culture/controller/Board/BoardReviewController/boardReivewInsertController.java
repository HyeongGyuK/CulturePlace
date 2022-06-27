package com.culture.controller.Board.BoardReviewController;

import com.culture.dto.BoardReviewFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class boardReivewInsertController {

	@GetMapping(value = "/insert/new")
	public String reviewInsertForm(Model model){
		model.addAttribute("boardReviewFormDto", new BoardReviewFormDto());
		return "thymeleaf/boardReview/boardReview_insert" ;
	}
	
}