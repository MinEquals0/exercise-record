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

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;; // 수정 시 변경 안됨

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

    // userId 대신 User 객체를 직접 참조하도록 변경
//    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 (여러 Feed가 한 User를 가짐)
//    @JoinColumn(name = "user_id", nullable = false) // DB 컬럼 이름 지정
//    private User user;

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