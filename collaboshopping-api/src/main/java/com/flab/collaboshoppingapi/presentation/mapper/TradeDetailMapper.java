package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.TradeParticipateRequest;
import com.flab.collaboshoppingapi.service.dto.TradeDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class TradeDetailMapper {
    public TradeDetailDTO fromTradeParticipateRequest(TradeParticipateRequest request){
        return new TradeDetailDTO(request.tradeId(),request.purchaseCount());
    }
}
