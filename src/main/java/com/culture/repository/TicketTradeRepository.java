package com.culture.repository;

import com.culture.entity.TicketTrade.TicketTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TicketTradeRepository extends JpaRepository<TicketTrade, Long>,
        QuerydslPredicateExecutor<TicketTrade>, TicketTradeRepositoryCustom {

    @Modifying
    @Query("update TicketTrade t set t.trade_readhit = t.trade_readhit + 1 where t.trade_no = :trade_no")
    int updateTicketTradeReadHit(Long trade_no);
}
