package com.example.goodyday.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @Column(name = "title")
    private String title;
    @Column(name = "guide")
    private String guideText;
    @Column(name = "content")
    private String content;
    @Column(name = "photo_url")
    private String photo_url;
    @Column(name = "level")
    private Integer level;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;



    public Mission(String title, String guideText, String content, String imageUrl, Integer level) {

    }

    public Mission() {

    }

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
