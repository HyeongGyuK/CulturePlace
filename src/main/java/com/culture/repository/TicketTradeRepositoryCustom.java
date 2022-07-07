package com.culture.repository;

import com.culture.dto.TicketTradeDto.TicketTradeSearchDto;
import com.culture.entity.TicketTrade.TicketTrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketTradeRepositoryCustom {
    Page<TicketTrade> getTicketTradePage(TicketTradeSearchDto ticketTradeSearchDto, Pageable pageable);
}
