package com.culture.controller.Board.BoardReviewController.insert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class boardReivewInsert {

	@GetMapping(value = "/insert")
	public String reviewInsert() {
		return "Board/Board_Review/boardReview_insert.jsp";
	}
	
}
