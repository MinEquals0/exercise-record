package com.soloproject.project.user.entity;

import java.time.LocalDateTime;

public class User {
    private Long userId;
    private String password;
    private String email;
    private String nickname;
    private String bio;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();


}