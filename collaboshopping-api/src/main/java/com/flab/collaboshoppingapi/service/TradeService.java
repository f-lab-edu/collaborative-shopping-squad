package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.common.exception.CustomException;
import com.flab.collaboshoppingapi.common.exception.ErrorCode;
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        trade.setMemberId(tradeDTO.getMemberId());
        trade.setCollaboratorId(tradeDTO.getCollaboratorId());
        return trade;
    }

    private TradeDTO convertEntityToDto(Trade trade) {
        TradeDTO tradeDTO = new TradeDTO();
        tradeDTO.setMemberId(trade.getMemberId());
        tradeDTO.setTitle(trade.getTitle());
        tradeDTO.setContent(trade.getContent());
        tradeDTO.setCollaboratorId(trade.getCollaboratorId());
        tradeDTO.setOriginUrl(trade.getOriginUrl());
        tradeDTO.setPerPrice(trade.getPerPrice());
        tradeDTO.setMinPurchaseCount(trade.getMinPurchaseCount());
        return tradeDTO;
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

    public long updateTrade(TradeDTO tradeDTO) {
        Trade trade = tradeRepository.findById(tradeDTO.getId())
                .orElseThrow(() -> new CustomException("Trade not found", ErrorCode.MEMBER_NOT_FOUND));
        trade.setTitle(tradeDTO.getTitle());
        trade.setContent(tradeDTO.getContent());
        trade.setMinPurchaseCount(tradeDTO.getMinPurchaseCount());
        trade.setOriginUrl(tradeDTO.getOriginUrl());
        trade.setSection(tradeDTO.getSection());
        trade.setPerPrice(tradeDTO.getPerPrice());
        return tradeRepository.save(trade).getId();
    }

    public long collaborateTrade(TradeDTO tradeDTO) {
        Trade trade = tradeRepository.findById(tradeDTO.getId())
                .orElseThrow(() -> new CustomException("Trade not found", ErrorCode.MEMBER_NOT_FOUND));
        trade.setCollaboratorId(tradeDTO.getCollaboratorId());
        return tradeRepository.save(trade).getId();
    }

    public long deleteTrade(TradeDTO tradeDTO) {
        Trade trade = tradeRepository.findById(tradeDTO.getId())
                .orElseThrow(() -> new CustomException("trade not found",ErrorCode.MEMBER_NOT_FOUND));
        tradeRepository.delete(trade);
        return tradeDTO.getId();
    }

    public List<TradeDTO> getTradeList() {
        List<Trade> tradeList = tradeRepository.findAll();
        return tradeList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());
    }

    public List<TradeDTO> getMemberTradeList(TradeDTO tradeDTO) {
        List<Trade> tradeList = tradeRepository.findAllById(Collections.singleton(tradeDTO.getMemberId()));
        return tradeList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());
    }

    public List<TradeDTO> getCollaboratorTradeList(TradeDTO tradeDTO) {
        List<Trade> tradeList = tradeRepository.findAllById(Collections.singleton(tradeDTO.getCollaboratorId()));
        return tradeList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());
    }

    public List<TradeDTO> getSectionTradeList(TradeDTO tradeDTO) {
        /*List<Trade> tradeList = tradeRepository.findAllBySection(tradeDTO.getSection());
        return tradeList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());*/
        return null;
    }

    public TradeDTO getTrade(TradeDTO tradeDTO) {
        Trade trade = tradeRepository.findById(tradeDTO.getId())
                .orElseThrow(() -> new CustomException("trade",ErrorCode.MEMBER_NOT_FOUND));
        return convertEntityToDto(trade);
    }
}
