package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.common.exception.DuplicateEmailException;
import com.flab.collaboshoppingapi.common.exception.ErrorCode;
import com.flab.collaboshoppingapi.common.exception.WrongPasswordException;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapp.entity.Member;
import com.flab.collaboshoppingapp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements UserDetailsService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Long join(MemberDTO memberDTO) {
        validateDuplicateEmail(memberDTO.getEmail());
        Member member = convertDtoToEntity(memberDTO);
        return memberRepository.save(member).getId();
    }

    @Transactional
    public void login(MemberDTO memberDTO) {
        loadUserByUsername(memberDTO.getEmail());



        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여

        /*token = new UsernamePasswordAuthenticationToken(userVo.getId(), null, roles);
        // 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token

        return token;*/

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

    private void validatePassword(MemberDTO checkInfo, Member originInfo) {
        if(!passwordEncoder.matches(checkInfo.getPw(),originInfo.getPwHash())){
            throw new WrongPasswordException("wrong password", ErrorCode.WRONG_PASSWORD);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));
    }
}
