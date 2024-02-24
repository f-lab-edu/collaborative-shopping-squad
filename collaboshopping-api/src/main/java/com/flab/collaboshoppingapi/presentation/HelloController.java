package com.flab.collaboshoppingapi.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flab.collaboshoppingapp.repository.BankRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final BankRepository bankRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Collabo Shopping!";
    }

    @GetMapping("/test-repository")
    public void test() {
        bankRepository.findAll(); 
    }
}
