package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BankRepositoryTest {
    @Autowired
    private BankRepository bankRepository;

    @Test
    public void find_by_code_test() {
        Bank bankTest = bankRepository.save(Bank.builder().code("005").build());

        Bank result = bankRepository.findByCode("005");

        Assertions.assertEquals(bankTest, result);
    }
}
