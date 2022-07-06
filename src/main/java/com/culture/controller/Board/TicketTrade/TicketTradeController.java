package com.culture.controller.Board.TicketTrade;

import com.culture.dto.BoardFreeDto.BoardFreeReplyDto;
import com.culture.dto.TicketTradeDto.TicketTradeDto;
import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.dto.TicketTradeDto.TicketTradeWriteDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.service.ReplyService;
import com.culture.service.TicketTradeService;
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

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TicketTradeController {

    private final TicketTradeService ticketTradeService;

    private final ReplyService replyService;

    @GetMapping(value = "/TicketTradeMain/ticket_trade_write")
    public String ticketTradeForm(Model model) {
        model.addAttribute("ticketTradeWriteDto", new TicketTradeWriteDto());
        return "thymeleaf/Board/TicketTrade/ticket_trade_write";
    }

    // 글 작성
    @PostMapping(value = "/TicketTradeMain/ticket_trade_write")
    public String boardWrite(@Valid TicketTradeWriteDto ticketTradeWriteDto,
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

            return "thymeleaf/Board/TicketTrade/ticket_trade_write";
        }

        try {
            ticketTradeService.savedTicketTradeWrite(ticketTradeWriteDto);
        }catch (Exception e) {
            model.addAttribute("errorMessage", "게시물 등록중 오류가 발생하였습니다.");
            return "thymeleaf/Board/BoardFree/board_free_write";
        }

        return "redirect:/TicketTradeMain"; // 거래 게시판 메인 페이지로 이동
    }



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

    // 게시글 상세보기
    @GetMapping(value = "/TicketTradeMain/ticket_trade_detail/{trade_no}")
    public String boardFreeDetail(TicketTradeReplyDto ticketTradeReplyDto,
                                  @PathVariable("board_no") Long trade_no,
                                  Model model, Principal principal) {
        TicketTradeDto ticketTradeDto = ticketTradeService.getTicketTradeDetail(trade_no);

        List<BoardFreeReplyDto> ticketTradeReplyPage = replyService.getReplyPage(trade_no);

        // userId를 담을 변수
        String userId = "";

        // 로그인을 하지 않을 시에 anonymousUser로 값을 반환한다.
        Object who = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String unknown = who.toString();

        // 사용자가 로그인을 하지 않았을 시에는 조회수가 오르지 않는다 또한 게시글의 작성자와 로그인한 사용자의 정보가 불일치 할 시 수정이 불가능하다.
        if(unknown == "anonymousUser"){
            userId = unknown;

            model.addAttribute("userId", userId);
            model.addAttribute("ticketTradeDto", ticketTradeDto);

            // 댓글 출력
            model.addAttribute("replyLists", ticketTradeReplyPage);
        }else{
            userId = principal.getName();

            // 조회수 증가
            if(!userId.equals(ticketTradeDto.getTrade_writer())){
                model.addAttribute("readhitPlus", ticketTradeService.updateTicketTradeReadHit(trade_no));
            }

            model.addAttribute("userId", userId);
            model.addAttribute("ticketTradeDto", ticketTradeDto);

            // 댓글 출력
            model.addAttribute("replyLists", ticketTradeReplyPage);
            // 댓글 작성
            model.addAttribute("replyWriteDto", new TicketTradeWriteDto());
        }

        return "thymeleaf/Board/TicketTrade/ticket_trade_detail";
    }

}
