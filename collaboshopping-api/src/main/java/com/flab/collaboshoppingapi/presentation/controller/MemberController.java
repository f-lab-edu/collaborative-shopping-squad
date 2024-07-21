package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.MemberMapper;
import com.flab.collaboshoppingapi.presentation.request.MemberJoinRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberLoginRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberSelectRequest;
import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapp.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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






}
