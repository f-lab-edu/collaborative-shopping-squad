package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.service.dto.TradeDetailDTO;
import com.flab.collaboshoppingapp.entity.TradeDetail;
import com.flab.collaboshoppingapp.repository.TradeDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeDetailService {

    private final TradeDetailRepository tradeDetailRepository;

    @Transactional
    public Long participate(TradeDetailDTO tradeDetailDTO) {
        TradeDetail tradeDetail = convertDtoToEntity(tradeDetailDTO);
        return tradeDetailRepository.save(tradeDetail).getId();
    }

    private TradeDetail convertDtoToEntity(TradeDetailDTO tradeDetailDTO) {
        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setTradeId(tradeDetailDTO.getTradeId());
        tradeDetail.setPurchaseCount(tradeDetailDTO.getPurchaseCount());

        return tradeDetail;
    }
}
