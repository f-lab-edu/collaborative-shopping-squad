package com.flab.collaboshoppingapi.presentation.request;
//레코드 특징 차이점
public record MemberUpdateRequest(long id,String name,String phone,String password,String role) {
    //길이제한, 유효성 체크
}
