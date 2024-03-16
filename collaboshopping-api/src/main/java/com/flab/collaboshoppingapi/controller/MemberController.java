package com.flab.collaboshoppingapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {
    @GetMapping("/member")
    public String member(){
        log.debug("test");
        return "";
    }



}
