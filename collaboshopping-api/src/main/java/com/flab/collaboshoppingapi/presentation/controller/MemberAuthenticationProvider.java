package com.flab.collaboshoppingapi.presentation.controller;

import com.flab.collaboshoppingapi.service.UserDetailServiceAdapter;
import com.flab.collaboshoppingapp.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.CredentialExpiredException;

@Component
@RequiredArgsConstructor
public class MemberAuthenticationProvider {

    private final UserDetailServiceAdapter UserDetailServiceAdapter;
    private final PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        Member member = (Member) UserDetailServiceAdapter
                .loadUserByUsername(username);

        try {
            //패스워드 체크
            if (!passwordEncoder.matches(password, member.getPwHash())) {
                throw new BadCredentialsException("Password is invalid");
            }

            if (!member.isAccountNonExpired()) {
                //계정 만료 여부
                throw new CredentialExpiredException("Account is expired");
            } else if (!member.isAccountNonLocked()) {
                //계정 잠금 여부
                throw new AccountLockedException("Account is locked");
            } else if (!member.isEnabled()) {
                //계정 사용 여부
                throw new LockedException("Can't use account");
            } else if (!member.isCredentialsNonExpired()) {
                //계정 비밀번호 만료 여부
                throw new CredentialExpiredException("Credentials is expired");
            }
        } catch (CredentialExpiredException e) {
            e.printStackTrace();
        } catch (AccountLockedException e) {
            e.printStackTrace();
        }

        //인증이 완료 후 객체 리턴
        return new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());
    }


    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}