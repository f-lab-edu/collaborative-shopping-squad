package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.service.dto.TradeDTO;
import org.springframework.stereotype.Component;

@Component
public class TradeMapper {
    public TradeDTO fromTradeRegisterRequest(TradeRegisterRequest request){
        return new TradeDTO(request.title(),request.content(),request.originUrl(),request.minPurchaseCount(),request.perPrice());
    }

    public TradeDTO fromTradeUpdateRequest(TradeUpdateRequest request) {
        return new TradeDTO(request.id(),request.title(),request.content(),request.originUrl(),request.minPurchaseCount(),request.perPrice());
    }

    public TradeDTO fromTradeDeleteRequest(TradeDeleteRequest request) {
        return new TradeDTO(request.id());
    }

    public TradeDTO fromMemberTradeListSelectrequest(MemberTradeListSelectRequest request) {
        return new TradeDTO(0,request.memberId(),0);
    }

    public TradeDTO fromSectionTradeListSelectrequest(SectionTradeListSelectRequest request) {
        return new TradeDTO(request.section());
    }

    public TradeDTO fromTradeSelectRequest(TradeSelectRequest request) {
        return new TradeDTO(request.id());
    }

    public TradeDTO fromCollaboratorTradeListSelectrequest(CollaboratorTradeListSelectRequest request) {
        return new TradeDTO(0,0,request.collaboratorId());
    }

    public TradeDTO fromTradeCollaborateRequest(TradeCollaborateRequest request) {
        return new TradeDTO(request.id(),0,request.collaboratorId());
    }
}
