package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {

    Bank findByCode(String code);

    Bank save(Bank build);
}
