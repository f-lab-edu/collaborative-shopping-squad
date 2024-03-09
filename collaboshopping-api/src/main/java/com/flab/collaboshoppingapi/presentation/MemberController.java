package com.flab.collaboshoppingapi.presentation;

import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController  {

    @Autowired
    private MemberService memberSevice;

    @GetMapping("/member")
    public String member() {
        log.info("good");
        log.info("hello world");
        return "member";
    }

    @PostMapping("/join")
    public void join(@RequestBody @Validated MemberDTO memberDTO) throws Exception {
        log.info("join");
        log.info(memberDTO.toString());
        memberDTO.setRole("member");
        memberSevice.join(memberDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated MemberDTO memberDTO) throws Exception {
        log.info("login");
        log.info(memberDTO.toString());
        memberSevice.login(memberDTO);
        return "";
    }

    @GetMapping("/getMemberList")
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> list = new ArrayList<>();
        return list;
    }



}
