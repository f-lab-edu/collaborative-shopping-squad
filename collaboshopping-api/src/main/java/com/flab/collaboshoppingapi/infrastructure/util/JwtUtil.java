package com.flab.collaboshoppingapi.infrastructure.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Slf4j
@Component
public class JwtUtil {

    /**
     * Access Token 생성
     * @param userName
     * @param expiredMs
     * @return Access Token String
     */
    public String createAccessToken(String userName, Long expiredMs) {
        return createJwt(userName, expiredMs);
    }

    /**
     * JWT 생성
     * @param userName
     * @param expiredMs
     * @return JWT String
     */
    private String createJwt(String userName, Long expiredMs){
        Claims claims = Jwts.claims();
        claims.put("userName",userName);
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        return Jwts.builder()
                .signWith(key)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * expiredMs))
                .compact();
    }


}
