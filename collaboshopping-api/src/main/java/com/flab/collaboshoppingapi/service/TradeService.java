package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.service.dto.TradeDTO;
import com.flab.collaboshoppingapp.entity.Trade;
import com.flab.collaboshoppingapp.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeService {

    private final TradeRepository tradeRepository;


    @Transactional
    public Long register(TradeDTO tradeDTO) {
        Trade trade = convertDtoToEntity(tradeDTO);
        return tradeRepository.save(trade).getId();
    }

    private Trade convertDtoToEntity(TradeDTO tradeDTO) {
        Trade trade = new Trade();
        trade.setTitle(tradeDTO.getTitle());
        trade.setContent(tradeDTO.getContent());
        trade.setOriginUrl(tradeDTO.getOriginUrl());
        trade.setPerPrice(tradeDTO.getPerPrice());
        trade.setMinPurchaseCount(tradeDTO.getMinPurchaseCount());
        return trade;
    }

}
