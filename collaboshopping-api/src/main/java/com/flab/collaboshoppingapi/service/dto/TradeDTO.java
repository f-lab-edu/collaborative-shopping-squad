package com.flab.collaboshoppingapi.service.dto;

import com.flab.collaboshoppingapp.entity.Trade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TradeDTO {

    private String title;

    private String content;

    private String originUrl;

    private int perPrice;

    private int minPurchaseCount;

    @Builder
    public TradeDTO(String title, String content, String originUrl, int perPrice, int minPurchaseCount) {
        this.title = title;
        this.content = content;
        this.originUrl = originUrl;
        this.perPrice = perPrice;
        this.minPurchaseCount = minPurchaseCount;
    }

    public Trade toEntity() {
        return Trade.builder()
                .title(title)
                .content(content)
                .build();
    }

    public TradeDTO toDto(Trade trade) {
        return TradeDTO.builder()
                .title(trade.getTitle())
                .content(trade.getContent())
                .originUrl(trade.getOriginUrl())
                .build();
    }

}
