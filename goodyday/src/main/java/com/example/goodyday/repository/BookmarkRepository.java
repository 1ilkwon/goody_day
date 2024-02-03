package com.example.goodyday.repository;

import com.example.goodyday.model.Bookmark;
import com.example.goodyday.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUser_DeviceId(String deviceId);
}
