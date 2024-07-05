package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade,Long> {


    Trade save(Trade trade);
}
