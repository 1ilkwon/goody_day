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

    @Column(name = "device_id", unique = true, nullable = false)
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


    // Enum for gender
    public enum Gender {
        MALE, FEMALE
    }

    // 생성자, 게터, 세터...
}

