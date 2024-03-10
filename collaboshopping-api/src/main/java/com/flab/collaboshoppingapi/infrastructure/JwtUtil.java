package com.flab.collaboshoppingapi.infrastructure;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {


    public static String createJwt(String userName, Long expiredMs){
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
