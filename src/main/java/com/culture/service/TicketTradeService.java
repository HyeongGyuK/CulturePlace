package com.culture.service;

import com.culture.dto.TicketTradeDto.TicketTradeDto;
import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.dto.TicketTradeDto.TicketTradeWriteDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.repository.TicketTradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketTradeService {

    private final TicketTradeRepository ticketTradeRepository;

    public Page<TicketTrade> getTicketTradePage(TicketTradeSearchDto ticketTradeSearchDto, Pageable pageable) {
        return ticketTradeRepository.getTicketTradePage(ticketTradeSearchDto, pageable);
    }

    public Long savedTicketTradeWrite(TicketTradeWriteDto ticketTradeWriteDto) throws Exception{
        TicketTrade ticketTradeWrite = ticketTradeWriteDto.ticketTradeWrite();
        ticketTradeRepository.save(ticketTradeWrite);
        return ticketTradeWrite.getTrade_no();
    }

    @Transactional(readOnly = true)
    public TicketTradeDto getTicketTradeDetail(Long trade_no) {
        TicketTrade ticketTrade = ticketTradeRepository.findById(trade_no).orElseThrow(EntityNotFoundException::new);
        TicketTradeDto ticketTradeDto = TicketTradeWriteDto.of(ticketTrade);
        return  ticketTradeDto;
    }

    public int updateTicketTradeReadHit(Long trade_no) {
        return ticketTradeRepository.updateTicketTradeReadHit(trade_no);
    }
}
