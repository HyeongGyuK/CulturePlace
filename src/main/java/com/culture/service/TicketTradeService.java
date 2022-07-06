package com.culture.service;

import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.entity.TicketTrade.TicketTrade;
import com.culture.repository.TicketTradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketTradeService {

    private final TicketTradeRepository ticketTradeRepository;

    public Page<TicketTrade> getTicketTradePage(TicketTradeSearchDto ticketTradeSearchDto, Pageable pageable) {
        return ticketTradeRepository.getTicketTradePage(ticketTradeSearchDto, pageable);
    }
}
