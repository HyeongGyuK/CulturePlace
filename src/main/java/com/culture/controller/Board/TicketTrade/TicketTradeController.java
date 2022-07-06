package com.culture.controller.Board.TicketTrade;

import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.service.TicketTradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TicketTradeController {

    private final TicketTradeService ticketTradeService;

    // 거래글 메인 페이지
    @GetMapping(value = {"/TicketTradeMain", "/TicketTradeMain/{page}"})
    public String ticketTradeMain(TicketTradeSearchDto ticketTradeSearchDto,
                            @PathVariable("page") Optional<Integer> page,
                            Model model) {

        // 티켓 거래 게시판 출력
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 10);

        Page<TicketTrade> ticketTrades = ticketTradeService.getTicketTradePage(ticketTradeSearchDto, pageable);

        model.addAttribute("TicketTrades", ticketTrades);
        model.addAttribute("TicketTradeSearchDto", ticketTradeSearchDto);
        model.addAttribute("maxPage", 5);

        return "thymeleaf/Board/TicketTrade/ticket_trade_main";
    }
}
