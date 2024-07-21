package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record AddressSelectRequest(long id,long memberId) {
    //길이제한, 유효성 체크
}
