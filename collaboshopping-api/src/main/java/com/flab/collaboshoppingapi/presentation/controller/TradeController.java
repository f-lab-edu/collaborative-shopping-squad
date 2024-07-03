package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.TradeMapper;
import com.flab.collaboshoppingapi.presentation.request.TradeRegisterRequest;
import com.flab.collaboshoppingapi.service.TradeService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
