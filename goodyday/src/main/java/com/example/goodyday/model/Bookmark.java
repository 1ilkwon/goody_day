package com.example.goodyday.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "bookmarks")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "mission_title", referencedColumnName = "title")
    private Mission mission;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Constructors, Getters, and Setters
}
