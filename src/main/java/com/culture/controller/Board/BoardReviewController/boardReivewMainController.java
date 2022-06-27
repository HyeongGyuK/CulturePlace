package com.culture.controller.Board.BoardReviewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class boardReivewMainController {

	@GetMapping(value = "/main")
	public String reviewDetail() {
		return "thymeleaf/boardReview/boardReview_main";
	}
	
}

