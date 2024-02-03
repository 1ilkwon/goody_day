package com.example.goodyday.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 기록만든 유저

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission; // 기록 관련 미션 id

    private String title;
    private String content;

    @Column(name = "photo_url")
    private String photoUrl; // AWS S3 URL

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // 생성자, 게터, 세터...
}
