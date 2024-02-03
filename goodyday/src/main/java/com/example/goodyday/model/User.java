package com.example.goodyday.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    @Column(name = "device_id", unique = true, nullable = false) // 수정된 부분
    private String deviceId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;

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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Bookmark> bookmarks = new ArrayList<>();
//
//    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
//    private List<Mission> missions = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Record> records = new ArrayList<>();


    // Enum for gender
    public enum Gender {
        MALE, FEMALE
    }

    // 생성자, 게터, 세터...
}

