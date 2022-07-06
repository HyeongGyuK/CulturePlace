package com.culture.repository;

import com.culture.entity.TicketTrade.TicketTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TicketTradeRepository extends JpaRepository<TicketTrade, Long>,
        QuerydslPredicateExecutor<TicketTrade>, TicketTradeRepositoryCustom {

}
