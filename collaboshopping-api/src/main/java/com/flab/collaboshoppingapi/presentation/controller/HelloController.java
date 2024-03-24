package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapp.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final BankRepository bankRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Collabo Shopping!";
    }

}
