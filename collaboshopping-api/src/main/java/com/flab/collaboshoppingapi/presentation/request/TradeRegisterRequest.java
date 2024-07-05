package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record TradeRegisterRequest(String title, String content, String originUrl, int perPrice, int minPurchaseCount) {
    //길이제한, 유효성 체크
}
