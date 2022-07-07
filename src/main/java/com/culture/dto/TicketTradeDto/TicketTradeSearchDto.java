package com.culture.dto.TicketTradeDto;

import com.culture.constant.TradeStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TicketTradeSearchDto {
    private String searchBy;
    private String searchQuery = "";
    private TradeStatus searchTradeStatus;
}
