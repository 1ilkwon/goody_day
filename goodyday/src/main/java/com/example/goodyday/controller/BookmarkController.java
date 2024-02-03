package com.example.goodyday.controller;

import com.example.goodyday.dto.BookmarkDto;
import com.example.goodyday.model.Bookmark;
import com.example.goodyday.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Bookmark> createBookmark(@RequestBody BookmarkDto request) {
        Bookmark bookmark = bookmarkService.createBookmark(request.getDeviceId(), request.getMissionTitle());
        return ResponseEntity.ok(bookmark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{deviceId}")
    public ResponseEntity<List<Bookmark>> getBookmarksByDeviceId(@PathVariable String deviceId) {
        List<Bookmark> bookmarks = bookmarkService.findBookmarksByDeviceId(deviceId);
        return ResponseEntity.ok(bookmarks);
    }
}

