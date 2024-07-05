package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.TradeRegisterRequest;
import com.flab.collaboshoppingapi.service.dto.TradeDTO;
import org.springframework.stereotype.Component;

@Component
public class TradeMapper {
    public TradeDTO fromTradeRegisterRequest(TradeRegisterRequest request){
        return new TradeDTO(request.title(),request.content(),request.originUrl(),request.minPurchaseCount(),request.perPrice());
    }

}
