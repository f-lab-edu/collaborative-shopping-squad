package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.TradeMapper;
import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.service.TradeService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapi.service.dto.TradeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.TRADE_V1)
public class TradeController {


    private final TradeService tradeService;
    private final TradeMapper tradeMapper;

    @PostMapping("/register")
    public boolean register(@RequestBody @Validated TradeRegisterRequest request) throws Exception {
        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        MemberDTO memberDTO = tradeService.getMember((user.getName()));
        tradeService.register(tradeMapper.fromTradeRegisterRequest(request),memberDTO.getId());
        return true;
    }

    @PutMapping("/collaborateTrade")
    public long collaborateTrade(@RequestBody @Validated TradeCollaborateRequest request){
        return tradeService.collaborateTrade(tradeMapper.fromTradeCollaborateRequest(request));
    }

    @PutMapping("/updateTrade")
    public long updateTrade(@RequestBody @Validated TradeUpdateRequest request){
        return tradeService.updateTrade(tradeMapper.fromTradeUpdateRequest(request));
    }

    @DeleteMapping("/deleteTrade")
    public long deleteTrade(@RequestBody @Validated TradeDeleteRequest request){
        return tradeService.deleteTrade(tradeMapper.fromTradeDeleteRequest(request));
    }

    @GetMapping("/getTradeList")
    public List<TradeDTO> getTradeList() {
        return tradeService.getTradeList();
    }

    @GetMapping("/getMemberTradeList")
    public List<TradeDTO> getMemberTradeList(@RequestBody @Validated MemberTradeListSelectRequest request) {
        return tradeService.getMemberTradeList(tradeMapper.fromMemberTradeListSelectrequest(request));
    }

    @GetMapping("/getCollaboratorTradeList")
    public List<TradeDTO> getCollaboratorTradeList(@RequestBody @Validated CollaboratorTradeListSelectRequest request) {
        return tradeService.getCollaboratorTradeList(tradeMapper.fromCollaboratorTradeListSelectrequest(request));
    }

    @GetMapping("/getSectionTradeList")
    public List<TradeDTO> getSectionTradeList(@RequestBody @Validated SectionTradeListSelectRequest request) {
        return tradeService.getSectionTradeList(tradeMapper.fromSectionTradeListSelectrequest(request));
    }

    @GetMapping("/getTrade")
    public TradeDTO getTrade(@RequestBody @Validated TradeSelectRequest request){
        return tradeService.getTrade(tradeMapper.fromTradeSelectRequest(request));
    }


}
