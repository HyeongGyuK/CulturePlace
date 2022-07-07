package com.culture.service;

import com.culture.controller.Board.TicketTrade.TicketTradeReplyDto;
import com.culture.dto.TicketTradeDto.TicketTradeReplyWriteDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.entity.TicketTrade.TicketTradeReply;
import com.culture.repository.TicketTradeReplyRepository;
import com.culture.repository.TicketTradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketTradeReplyService {

    private final TicketTradeRepository ticketTradeRepository;

    private final TicketTradeReplyRepository ticketTradeReplyRepository;

    public TicketTradeReply savedTicketTradeReplyWrite(TicketTradeReplyWriteDto ticketTradeReplyWriteDto, Long trade_no) throws Exception{
        TicketTradeReply ticketTradeReply = ticketTradeReplyWriteDto.replyWrite();
        ticketTradeReply.setReply_content(ticketTradeReply.getReply_content());
//        boardFreeReply.setBoard_no(board_no);
//        boardFreeReply.setBoard_no(board_no);
        TicketTrade ticketTrade = ticketTradeRepository.findById(trade_no).orElseThrow(EntityNotFoundException::new);

        ticketTradeReply.setTicketTrade(ticketTrade);
        ticketTradeReplyRepository.save(ticketTradeReply);

//        BoardFreeReply boardFreeReply = new BoardFreeReply();



//        boardFreeReply.setReply_no(boardFreeReplyWriteDto.getReply_no());
//
//        boardFreeReply.setReply_regdate(boardFreeReplyWriteDto.getReply_regdate());
//        boardFreeReply.setReply_writer(boardFreeReply.getReply_writer());

//        return boardFreeReply.getReply_no();
        return ticketTradeReply;
    }

    public List<TicketTradeReplyDto> getTicketTradeReplyPage(Long trade_no) throws Exception{

        TicketTrade ticketTrade = ticketTradeRepository.getById(trade_no);

        TicketTradeReply ticketTradeReply = null;
        List<TicketTradeReplyDto> ticketTradeReplyDtoList = new ArrayList<>();
        try {
            ticketTradeReply = ticketTradeReplyRepository.findByTicketTrade(ticketTrade);

            if(ticketTradeReply == null){
                return ticketTradeReplyDtoList;
            }else{
//            BoardFree boardNo = boardFreeReply.getBoardFree();
                ticketTradeReplyDtoList = ticketTradeReplyRepository.findByTicketTradeReplyDtoList(trade_no);
                return ticketTradeReplyDtoList;
            }

        }catch ( Exception e){
            ticketTradeReplyDtoList = ticketTradeReplyRepository.findByTicketTradeReplyDtoList(trade_no);
            return ticketTradeReplyDtoList;
        }
    }
}
