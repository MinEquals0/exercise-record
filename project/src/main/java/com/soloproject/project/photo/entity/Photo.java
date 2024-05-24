package com.soloproject.project.photo.entity;

import com.soloproject.project.feed.entity.Feed;
import jakarta.persistence.ManyToOne;


public class Photo {
    private Long photoId;
    private String photoUrl;

    @ManyToOne
    private Feed feed;

}
