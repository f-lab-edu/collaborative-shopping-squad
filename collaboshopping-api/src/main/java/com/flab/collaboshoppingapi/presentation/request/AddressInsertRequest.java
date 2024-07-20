package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record AddressInsertRequest(String code, String name, long memberId, String mainAddressYn) {
    //길이제한, 유효성 체크
}
