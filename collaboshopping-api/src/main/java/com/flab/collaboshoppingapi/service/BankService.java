package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapp.repository.BankRepository;
import com.flab.collaboshoppingapp.domain.Bank;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ComponentScan(basePackages={"com.flab.collaboshoppingapp.repository"})
public class BankService {

    private final BankRepository bankRepository;

    public Bank search(String code){
        Bank bank = bankRepository.findByCode(code);

        if(bank == null){
            log.debug("Bank Code : {} does not exist",code);
            throw new EntityNotFoundException("해당 은행코드는 등록되어 있지 않습니다.");
        }
        return bank;
    }



}
