package com.soloproject.project.security.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    private final long tokenValidityInMilliseconds = 1000 * 60 & 60; // 1시간

    // 토큰 생성
    public String createToken(String email, List<String> roles) {
        // JWT claims (사용자 정보 등 포함)
        Claims claims = Jwts.claims().setSubject(email);  // email을 subject로 설정
        claims.put("roles", roles);  // 역할 정보 'roles'를 JWT에 넣기

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);  // 1시간 유효

        // JWT 생성
        return Jwts.builder()
                .setClaims(claims)  // claims 정보 추가
                .setIssuedAt(now)  // 발급 시간
                .setExpiration(validity)  // 만료 시간
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 서명 (비밀키로 서명)
                .compact();  // JWT 문자열 반환
    }



    // 토큰에서 사용자 정보 가져오기
    public Authentication getAuthentication(String token, UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰에서 이메일 추출
    public String getEmailFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰 유효성 검사
    public boolean validationToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }
}