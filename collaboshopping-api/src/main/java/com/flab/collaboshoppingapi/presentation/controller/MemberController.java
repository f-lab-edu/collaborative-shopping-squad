package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.MemberMapper;
import com.flab.collaboshoppingapi.presentation.request.MemberJoinRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberLoginRequest;
import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.MEMBER_V1)
public class MemberController  {


    private final MemberService memberSevice;
    private final MemberMapper memberMapper;


    @PostMapping("/join")
    public boolean join(@RequestBody @Validated MemberJoinRequest request) throws Exception {
        memberSevice.join(memberMapper.fromMemberJoinRequest(request));
        return true;
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated MemberLoginRequest request) throws Exception {

        return memberSevice.login(memberMapper.fromMemberLoginRequest(request));

    }

    //limit-offset 페이징 - limit-where 조건절로 처리가능
    @GetMapping("/getMembers")
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> list = new ArrayList<>();
        return list;
    }






}
