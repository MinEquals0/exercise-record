package com.soloproject.project.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column
    private String bio;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 수정 시 변경 안됨

    @Column(nullable = false)
    LocalDateTime modifiedAt = LocalDateTime.now();

    //     새로운 엔티티 생성 시 createdAt과 modifiedAt 자동 설정
    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    // 엔티티 수정 시 modifiedAt이 자동으로 업데이트됨
    @PreUpdate
    protected void onUpdate(){
        this.modifiedAt = LocalDateTime.now();
    }

//    @Column(nullable = false, name = "CREATED_AT")
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @Column(nullable = false, name = "MODIFIED_AT")
//    private LocalDateTime modifiedAt = LocalDateTime.now();

//    //한 사람이 여러개 피드 만들 수 있음
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private final List<Feed> feedList = new ArrayList<>();
}