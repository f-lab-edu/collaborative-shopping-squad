package com.flab.collaboshoppingapp.repository;

import com.flab.collaboshoppingapp.entity.TradeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeDetailRepository extends JpaRepository<TradeDetail,Long> {


    TradeDetail save(TradeDetail tradeDetail);
}
