package com.culture.controller.Board.BoardReviewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class boardReivewDetailController {

	@GetMapping(value = "/detail")
	public String reviewDetail() {
		return "Board/Board_Review/boardReview_detail.jsp";
	}
	
}

