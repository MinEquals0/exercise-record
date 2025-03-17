package com.soloproject.project.user.entity;

import com.soloproject.project.feed.entity.Feed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false, name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    //한 사람이 여러개 피드 만들 수 있음
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<Feed> feedList = new ArrayList<>();
}