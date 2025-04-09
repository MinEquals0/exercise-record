package com.soloproject.project.feed.controller;

import com.soloproject.project.feed.entity.Feed;
import com.soloproject.project.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;

    // 피드 등록
    @PostMapping("/add")
    public ResponseEntity<Feed> postFeed(@RequestBody Feed feed){
        return ResponseEntity.ok(feedService.createFeed(feed));
    }

    // 피드 수정
    @PutMapping("/{feedId}")
    public ResponseEntity<Feed> putFeed(@PathVariable Long feedId, @RequestBody Feed feed){
        return ResponseEntity.ok(feedService.updateFeed(feedId, feed));
    }

    // 특정 피드 조회
    @GetMapping("/{feedId}")
    public ResponseEntity<Feed> findFeedById(@PathVariable Long feedId){
        return ResponseEntity.ok(feedService.getFeed(feedId));
    }

    // 피드 전체 조회
    @GetMapping
    public ResponseEntity<List<Feed>> findAllFeed(){
        return ResponseEntity.ok(feedService.getAllFeeds());
    }

    // 피드 삭제
    @DeleteMapping("/{feedId}")
    public ResponseEntity<Void> deleteFeed(@PathVariable Long feedId){
        feedService.deleteFeed(feedId);
        return ResponseEntity.noContent().build();
    }


}
