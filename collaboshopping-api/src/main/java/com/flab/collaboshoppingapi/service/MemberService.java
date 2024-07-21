package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.common.exception.CustomException;
import com.flab.collaboshoppingapi.common.exception.ErrorCode;
import com.flab.collaboshoppingapi.infrastructure.util.JWTUtil;
import com.flab.collaboshoppingapi.service.dto.MemberDTO;
import com.flab.collaboshoppingapp.entity.Member;
import com.flab.collaboshoppingapp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    @Value("${jwt.expiredMs}")
    Long expiredMs;
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailServiceAdapter userDetailServiceAdapter;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;

    @Transactional
    public Long join(MemberDTO memberDTO) {
        validateDuplicateEmail(memberDTO.getEmail());
        Member member = convertDtoToEntity(memberDTO);
        return memberRepository.save(member).getId();
    }

    @Transactional
    public String login(MemberDTO memberDTO) {
        UserDetails member = userDetailServiceAdapter.loadUserByUsername(memberDTO.getEmail());

        validatePassword(memberDTO.getPassword(),member.getPassword());

        //엑세스토큰(짧은시간), 리프레쉬토큰(긴시간)
        //엑세스토큰 만료 시 리프레쉬토큰을 통해 발급
        //엑세스토큰 설정 해두고
        return jwtUtil.createJwt(memberDTO.getEmail(),"ROLE_USER",expiredMs * 1000 * 60L);



    }

    private Member convertDtoToEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setRole(memberDTO.getRole());
        member.setEmail(memberDTO.getEmail());
        member.setPwHash(passwordEncoder.encode(memberDTO.getPassword()));
        member.setUuid(UUID.randomUUID().toString().replace("-", ""));
        return member;
    }

    private MemberDTO convertEntityToDto(Member member) {
        MemberDTO memberDto = new MemberDTO();
        memberDto.setName(member.getName());
        memberDto.setRole(member.getRole());
        memberDto.setEmail(member.getEmail());
        return memberDto;
    }

    private void validateDuplicateEmail(String email) {
        if(memberRepository.existsByEmail(email)){
            throw new CustomException("email duplicated", ErrorCode.EMAIL_DUPLICATION);
        }
    }

    private void validatePassword(String password, String passwordHash) {
        if(!passwordEncoder.matches(password,passwordHash)){
            throw new CustomException("wrong password", ErrorCode.WRONG_PASSWORD);
        }
    }


    public Member getMember(String mail) {
        Member member = memberRepository.findByEmail(mail)
                .orElseThrow(() -> new CustomException("member not found",ErrorCode.MEMBER_NOT_FOUND));
        return member;
    }

    public List<MemberDTO> getMembersList() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream()
                .map(data -> convertEntityToDto(data))
                .collect(Collectors.toList());

    }

    public MemberDTO getMemberInfo(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.getId())
                .orElseThrow(() -> new CustomException("member not found",ErrorCode.MEMBER_NOT_FOUND));
        return convertEntityToDto(member);

    }

    public long updateMember(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.getId())
                .orElseThrow(() -> new CustomException("member not found",ErrorCode.MEMBER_NOT_FOUND));
        member.setName(memberDTO.getName());
        member.setPwHash(passwordEncoder.encode(memberDTO.getPassword()));
        member.setPhone(memberDTO.getPhone());
        member.setRole(memberDTO.getRole());

        return memberRepository.save(member).getId();
    }

    public long deleteMember(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.getId())
                .orElseThrow(() -> new CustomException("member not found",ErrorCode.MEMBER_NOT_FOUND));
        memberRepository.delete(member);
        return memberDTO.getId();
    }
}
