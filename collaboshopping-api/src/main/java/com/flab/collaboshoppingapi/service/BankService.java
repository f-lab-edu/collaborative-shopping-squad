package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapp.entity.Bank;
import com.flab.collaboshoppingapp.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;

    public Bank search(String code){
        Bank bank = bankRepository.findByCode(code);

        if(bank == null){
            log.debug("Bank Code : {} does not exist",code);
        }
        return bank;
    }
}
