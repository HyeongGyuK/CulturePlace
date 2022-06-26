package com.culture.controller.crawling.move_page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/move")
public class movePageController {
	
	@GetMapping(value = "/CulturePlace")
	public String moveCulturePlace(@RequestParam(value = "playNum") int playNum, Model model) {
		
		model.addAttribute("playNum", playNum);
		
		return "CulturePlace/Detail/culturePlaceDB";
	}
	
	@GetMapping(value = "/review_board")
	public String moveReviewBoard() {
		return "Board/Board_Review/boardReview_main";
	}
	
	@GetMapping(value = "/free_board")
	public String freeReviewBoard() {
		return "Board/BoardFree/board_free_main";
	}
	
	@GetMapping(value = "/ticket_board")
	public String ticketReviewBoard() {
		return "Board/TicketTrade/ticket_trade_main";
	}
}
