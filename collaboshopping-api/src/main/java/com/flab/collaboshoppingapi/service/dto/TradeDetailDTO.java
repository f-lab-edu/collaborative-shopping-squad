package com.flab.collaboshoppingapi.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TradeDetailDTO {

    private long tradeId;

    private int purchaseCount;

    public TradeDetailDTO(long tradeId, int purchaseCount) {
        this.tradeId = tradeId;
        this.purchaseCount = purchaseCount;
    }

}
