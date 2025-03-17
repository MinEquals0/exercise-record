package com.soloproject.project.photo.entity;

import com.soloproject.project.feed.entity.Feed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    @JoinColumn
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

}
