package com.flab.collaboshoppingapi.presentation;

import com.flab.collaboshoppingapi.service.MemberService;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/member")
public class MemberController  {



    @Autowired
    private MemberService memberSevice;

    @GetMapping("/")
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
    public ResponseEntity<String> login(@RequestBody @Validated MemberDTO memberDTO) throws Exception {
        log.info("login");
        log.info(memberDTO.toString());
        return ResponseEntity.ok().body(memberSevice.login(memberDTO));
    }

    @GetMapping("/getMemberList")
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> list = new ArrayList<>();
        return list;
    }



}
