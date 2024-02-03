package com.example.goodyday.controller;

import com.example.goodyday.model.Bookmark;
import com.example.goodyday.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping
    // 생성
    public Bookmark createBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkService.createBookmark(bookmark);
    }

    @DeleteMapping("/{id}")
    // 삭제
    public void deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
    }

    @GetMapping("/user/{userId}")
    // 유저 북마크 조회
    public List<Bookmark> getBookmarksByUserId(@PathVariable Long userId) {
        return bookmarkService.getBookmarksByUserId(userId);
    }
}
