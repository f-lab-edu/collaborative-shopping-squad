package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.presentation.mapper.MemberMapper;
import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(ApiPath.ADMIN_V1)
public class AdminController {


    private final MemberService memberService;
    private final MemberMapper memberMapper;

    //limit-offset 페이징 - limit-where 조건절로 처리가능
    @GetMapping("/getMembersList")
    public List<MemberDTO> getMembersList() {
        return memberService.getMembersList();
    }







}
