package com.soloproject.project.user.controller;

import com.soloproject.project.security.jwt.JwtTokenProvider;
import com.soloproject.project.user.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

// 로그인 API
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class Authcontroller {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtTokenProvider.createToken(
                authentication.getName(), // 이메일
                Collections.singletonList("ROLE_USER") // 권한 리스트
        );


//        String token = jwtTokenProvider.createToken(authentication.getName());

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
