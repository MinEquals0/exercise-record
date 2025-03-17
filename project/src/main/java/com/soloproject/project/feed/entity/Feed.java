package com.soloproject.project.feed.entity;

import com.soloproject.project.photo.entity.Photo;
import com.soloproject.project.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Column
    private String title;

    @Column
    private String content;

    @Column(nullable = false)
    LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    LocalDateTime modifiedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 피드에 여러개 사진 올릴 수 있으니까
    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();
}