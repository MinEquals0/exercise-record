package com.soloproject.project.feed.repository;

import com.soloproject.project.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// 기본적인 CRUD 메서드 (save, findById, findAll, delete 등) 를 자동으로 제공
@Repository
public interface FeedRepository extends JpaRepository<Feed, Long> {
//    List<Feed> findByUser_UserId(Long userId); // 사용자별 운동 기록 조회
}
