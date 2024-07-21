package com.flab.collaboshoppingapi.presentation.mapper;

import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.presentation.response.MemberLoginResponse;
import com.flab.collaboshoppingapi.service.dto.AddressDTO;
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

    public MemberDTO fromMemberSelectRequest(MemberSelectRequest request) {
        return new MemberDTO(request.id());
    }

    public MemberDTO fromMemberUpdateRequest(MemberUpdateRequest request) {
        return new MemberDTO(request.id(),request.password(),request.name(),request.phone(),request.role());
    }

    public MemberDTO fromMemberDeleteRequest(MemberDeleteRequest request) {
        return new MemberDTO(request.id());
    }

    public AddressDTO fromAddressListSelectrequest(AddressListSelectRequest request) {
        return new AddressDTO(request.memberId());
    }

    public AddressDTO fromAddressSelectRequest(AddressSelectRequest request) {
        return new AddressDTO(request.id(),request.memberId());
    }

    public AddressDTO fromAddressUpdateRequest(AddressUpdateRequest request) {
        return new AddressDTO(request.id(),request.code(),request.name(),request.memberId(),request.mainAddressYn(),request.section());

    }

    public AddressDTO fromAddressDeleteRequest(AddressDeleteRequest request) {
        return new AddressDTO(request.id(),request.memberId());
    }

    public AddressDTO fromAddressInsertRequest(AddressInsertRequest request) {
        return new AddressDTO(request.code(),request.name(),request.memberId(),request.mainAddressYn(),request.section());
    }
}
