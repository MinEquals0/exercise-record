package com.soloproject.project.feed.service;

import com.soloproject.project.feed.entity.Feed;
import com.soloproject.project.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;

    // 피드 생성 - 운동 기록 저장
    public Feed createFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    // 단일 피드 조회
    public Feed getFeed(Long feedId){
        return feedRepository.findById(feedId)
                .orElseThrow(() -> new RuntimeException("Feed not found with feedId: " + feedId));
    }

    // 모든 피드 조회
    public List<Feed> getAllFeeds(){
        return feedRepository.findAll();
    }

    // 피드 수정 - updatedFeed 보내는 곳 체크
    public Feed updateFeed(Long feedId, Feed updatedFeed){
        Feed existingFeed = getFeed(feedId);
        existingFeed.setExerciseName(updatedFeed.getExerciseName());
        existingFeed.setDuration(updatedFeed.getDuration());
        existingFeed.setExerciseDate(updatedFeed.getExerciseDate());
        existingFeed.setMemo(updatedFeed.getMemo());
        return feedRepository.save(updatedFeed);
    }

    // 피드 삭제
    public void deleteFeed(Long feedId){
        feedRepository.deleteById(feedId);
    }





}
