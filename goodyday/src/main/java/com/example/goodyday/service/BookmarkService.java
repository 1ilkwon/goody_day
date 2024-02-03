package com.example.goodyday.service;

import com.example.goodyday.model.Bookmark;

import java.util.List;

public interface BookmarkService {
    Bookmark createBookmark(Bookmark bookmark);
    void deleteBookmark(Long bookmarkId);
    List<Bookmark> getBookmarksByUserId(Long userId);
    // 기타 필요한 메소드
}