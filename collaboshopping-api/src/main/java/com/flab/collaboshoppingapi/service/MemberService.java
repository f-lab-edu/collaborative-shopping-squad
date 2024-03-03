package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.dto.MemberDTO;
import com.flab.collaboshoppingapi.exception.DuplicateEmailException;
import com.flab.collaboshoppingapi.exception.ErrorCode;
import com.flab.collaboshoppingapp.entity.Member;
import com.flab.collaboshoppingapp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(MemberDTO memberDTO) {
        validateDuplicateEmail(memberDTO.getEmail());
        Member member = convertDtoToEntity(memberDTO);
        memberRepository.save(member);
    }

    private Member convertDtoToEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setRole(memberDTO.getRole());
        member.setEmail(memberDTO.getEmail());
        member.setPwHash(passwordEncoder.encode(memberDTO.getPw()));
        member.setUuid(UUID.randomUUID().toString().replace("-", ""));
        return member;
    }

    private void validateDuplicateEmail(String email) {
        if(memberRepository.existsByEmail(email)){
            throw new DuplicateEmailException("email duplicated", ErrorCode.EMAIL_DUPLICATION);
        }
    }


}
