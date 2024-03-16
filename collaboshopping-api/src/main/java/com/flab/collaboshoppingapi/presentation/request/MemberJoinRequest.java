package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record MemberJoinRequest(String email, String password,String phone, String name) {
    //길이제한, 유효성 체크
}
