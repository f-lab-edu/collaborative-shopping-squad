package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.MemberMapper;
import com.flab.collaboshoppingapi.presentation.request.MemberJoinRequest;
import com.flab.collaboshoppingapi.presentation.request.MemberLoginRequest;
import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/")
    public String member() {
        log.info("good");
        log.info("hello world");
        return "member";
    }

    @PostMapping("/join")
    public void join(@RequestBody @Validated MemberJoinRequest request) throws Exception {
        log.info("join");
        log.info(request.toString());
        memberSevice.join(memberMapper.fromMemberJoinRequest(request));
    }

    @PostMapping("/login")
    public void login(@RequestBody @Validated MemberLoginRequest request) throws Exception {
        log.info("login");
        log.info(request.toString());
        String token = memberSevice.login(memberMapper.fromMemberLoginRequest(request));
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info(token);
        log.info(name);
    }

    //limit-offset 페이징 - limit-where 조건절로 처리가능
    @GetMapping("/getMembers")
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> list = new ArrayList<>();
        return list;
    }






}
