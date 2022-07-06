//package com.culture.service;
//
//import com.culture.controller.Board.TicketTrade.TicketTradeReplyDto;
//import com.culture.entity.TicketTrade.TicketTrade;
//import com.culture.entity.TicketTrade.TicketTradeReply;
//import com.culture.repository.TicketTradeReplyRepository;
//import com.culture.repository.TicketTradeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class TicketTradeReplyService {
//
//    private final TicketTradeRepository ticketTradeRepository;
//
//    private final TicketTradeReplyRepository ticketTradeReplyRepository;
//
//    public List<TicketTradeReplyDto> getTicketTradeReplyPage(Long trade_no) {
//
//        TicketTrade ticketTrade = ticketTradeRepository.getById(trade_no);
//
//        TicketTradeReply ticketTradeReply = null;
//        List<TicketTradeReplyDto> ticketTradeReplyDtoList = new ArrayList<>();
//        try {
//            ticketTradeReply = ticketTradeReplyRepository.findByTicketTrade(ticketTrade);
//
//            if(ticketTradeReply == null){
//                return ticketTradeReplyDtoList;
//            }else{
////            BoardFree boardNo = boardFreeReply.getBoardFree();
//                ticketTradeReplyDtoList = ticketTradeReplyRepository.findByTicketTradeReplyDtoList(trade_no);
//                return ticketTradeReplyDtoList;
//            }
//
//        }catch ( Exception e){
//            ticketTradeReplyDtoList = ticketTradeReplyRepository.findByTicketTradeReplyDtoList(trade_no);
//            return ticketTradeReplyDtoList;
//        }
//    }
//}
