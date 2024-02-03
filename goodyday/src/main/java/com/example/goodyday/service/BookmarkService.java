package com.example.goodyday.service;

import com.example.goodyday.model.Bookmark;

import java.util.List;

public interface BookmarkService {
    Bookmark createBookmark(String deviceId, String missionTitle);
    void deleteBookmark(Long bookmarkId);
    List<Bookmark> findBookmarksByDeviceId(String deviceId);
    // 기타 필요한 메소드
}