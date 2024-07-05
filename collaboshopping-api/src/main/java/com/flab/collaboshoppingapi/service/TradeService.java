package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapi.service.dto.TradeDTO;
import com.flab.collaboshoppingapp.entity.Member;
import com.flab.collaboshoppingapp.entity.Trade;
import com.flab.collaboshoppingapp.repository.MemberRepository;
import com.flab.collaboshoppingapp.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeService {

    private final TradeRepository tradeRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public Long register(TradeDTO tradeDTO,Long memberId) {
        Trade trade = convertDtoToEntity(tradeDTO);
        trade.setMemberId(memberId);
        return tradeRepository.save(trade).getId();
    }

    private Trade convertDtoToEntity(TradeDTO tradeDTO) {
        Trade trade = new Trade();
        trade.setTitle(tradeDTO.getTitle());
        trade.setContent(tradeDTO.getContent());
        trade.setOriginUrl(tradeDTO.getOriginUrl());
        trade.setPerPrice(tradeDTO.getPerPrice());
        trade.setMinPurchaseCount(tradeDTO.getMinPurchaseCount());
        return trade;
    }

    private MemberDTO convertMemberEntityToDto(Optional<Member> member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId((member.get().getId()));
        memberDTO.setName(member.get().getName());
        memberDTO.setRole(member.get().getRole());
        memberDTO.setPassword(member.get().getPwHash());
        memberDTO.setPhone(member.get().getPhone());
        return memberDTO;
    }
    @Transactional
    public MemberDTO getMember(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        return convertMemberEntityToDto(member);
    }
}
