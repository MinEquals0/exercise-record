package com.soloproject.project.feed.entity;

import com.soloproject.project.photo.entity.Photo;
import com.soloproject.project.user.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;

public class Feed {
    private Long feedId;
    private String title;
    private String content;
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime modifiedAt = LocalDateTime.now();

    @ManyToOne
    private User user;

    @OneToMany
    private Photo photo;
}