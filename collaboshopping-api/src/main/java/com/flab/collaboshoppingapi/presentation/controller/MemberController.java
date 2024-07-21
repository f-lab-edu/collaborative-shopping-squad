package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.MemberMapper;
import com.flab.collaboshoppingapi.presentation.request.*;
import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.AddressDTO;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapp.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.MEMBER_V1)
public class MemberController  {


    private final MemberService memberService;
    private final MemberMapper memberMapper;


    @PostMapping("/join")
    public boolean join(@RequestBody @Validated MemberJoinRequest request) throws Exception {
        memberService.join(memberMapper.fromMemberJoinRequest(request));
        return true;
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated MemberLoginRequest request) throws Exception {

        return memberService.login(memberMapper.fromMemberLoginRequest(request));

    }

    @GetMapping("/getCurrentMember")
    public Long getCurrentMember(Authentication authentication){
        log.info("authentication.getName() : " + authentication.getName());
        Member member = memberService.getMember(authentication.getName());
        return member.getId();
    }

    @GetMapping("/getMember")
    public MemberDTO getMember(@RequestBody @Validated MemberSelectRequest request){
        return memberService.getMemberInfo(memberMapper.fromMemberSelectRequest(request));
    }

    @PutMapping("/updateMember")
    public long updateMember(@RequestBody @Validated MemberUpdateRequest request){
        return memberService.updateMember(memberMapper.fromMemberUpdateRequest(request));
    }

    @DeleteMapping("/deleteMember")
    public long deleteMember(@RequestBody @Validated MemberDeleteRequest request){
        return memberService.deleteMember(memberMapper.fromMemberDeleteRequest(request));
    }

    @GetMapping("/getMemberAddressList")
    public List<AddressDTO> getMemberAddressList(@RequestBody @Validated AddressListSelectRequest request) {
        return memberService.getMemberAddressList(memberMapper.fromAddressListSelectrequest(request));
    }

    @GetMapping("/getAddress")
    public AddressDTO getAddress(@RequestBody @Validated AddressSelectRequest request){
        return memberService.getAddress(memberMapper.fromAddressSelectRequest(request));
    }

    @PostMapping("/insertAddress")
    public long insertAddress(@RequestBody @Validated AddressInsertRequest request){
        return memberService.insertAddress(memberMapper.fromAddressInsertRequest(request));
    }

    @PutMapping("/updateAddress")
    public long updateAddress(@RequestBody @Validated AddressUpdateRequest request){
        return memberService.updateAddress(memberMapper.fromAddressUpdateRequest(request));
    }

    @DeleteMapping("/deleteAddress")
    public long deleteAddress(@RequestBody @Validated AddressDeleteRequest request){
        return memberService.deleteAddress(memberMapper.fromAddressDeleteRequest(request));
    }





}
