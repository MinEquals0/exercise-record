package com.soloproject.project.feed.entity;

import com.soloproject.project.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@Entity // JPA 엔티티 임을 선언
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
    private Long feedId;

    // 운동 이름
    @Column(nullable = false)
    private String exerciseName;

    // 운동 날짜, 시간
    @Column(nullable = false)
    private LocalDateTime exerciseDate;

    // 운동시간(분)
    private Integer duration;

    // 추가 메모
    private String memo;

    @Column(nullable = false, updatable = false) // 수정 시 업뎃 안됨
    LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    LocalDateTime modifiedAt = LocalDateTime.now();

    // userId 대신 User 객체를 직접 참조하도록 변경
    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 (여러 Feed가 한 User를 가짐)
    @JoinColumn(name = "user_id", nullable = false) // DB 컬럼 이름 지정
    private User user;

 /*
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();  // 생성 시간

    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    이렇게 사용해도 됨
 */

}