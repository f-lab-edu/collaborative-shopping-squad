package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record CollaboratorApplyRequest(String address, String name) {
    //길이제한, 유효성 체크
}
