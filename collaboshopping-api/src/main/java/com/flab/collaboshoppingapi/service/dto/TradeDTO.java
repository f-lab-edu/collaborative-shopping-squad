package com.flab.collaboshoppingapi.service.dto;

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


    public TradeDTO(String title, String content, String originUrl, int perPrice, int minPurchaseCount) {
        this.title = title;
        this.content = content;
        this.originUrl = originUrl;
        this.perPrice = perPrice;
        this.minPurchaseCount = minPurchaseCount;
    }

}
