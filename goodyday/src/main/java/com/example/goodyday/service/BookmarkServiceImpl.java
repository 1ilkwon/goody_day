package com.example.goodyday.service;

import com.example.goodyday.model.Bookmark;
import com.example.goodyday.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Bookmark createBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @Override
    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }

    @Override
    public List<Bookmark> getBookmarksByUserId(Long userId) {
        return bookmarkRepository.findByUserId(userId);
    }
}