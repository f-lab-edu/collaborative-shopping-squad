package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.MemberJoinRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberLoginRequest;
import com.flab.collaboshoppingapi.presentation.response.MemberLoginResponse;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberDTO fromMemberLoginRequest(MemberLoginRequest request){
        return new MemberDTO(request.email(),request.password());
    }

    public MemberLoginResponse toMemberLoginResponse(MemberDTO memberDTO){
        return new MemberLoginResponse(memberDTO.getEmail(),memberDTO.getPassword());
    }


    public MemberDTO fromMemberJoinRequest(MemberJoinRequest request) {
        return new MemberDTO(request.email(),request.password(),request.name(),request.phone(),"member");
    }
}
