package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.TradeDetailMapper;
import com.flab.collaboshoppingapi.presentation.request.TradeParticipateRequest;
import com.flab.collaboshoppingapi.service.TradeDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.TRADEDETAIL_V1)
public class TradeDetailController {


    private final TradeDetailService tradeDetailService;
    private final TradeDetailMapper tradeDetailMapper;

    @PostMapping("/participate")
    public boolean participate(@RequestBody @Validated TradeParticipateRequest request) throws Exception {
        tradeDetailService.participate(tradeDetailMapper.fromTradeParticipateRequest(request));
        return true;
    }








}
