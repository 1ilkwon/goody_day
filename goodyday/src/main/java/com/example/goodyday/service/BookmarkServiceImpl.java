package com.example.goodyday.service;

import com.example.goodyday.model.Bookmark;
import com.example.goodyday.model.Mission;
import com.example.goodyday.model.User;
import com.example.goodyday.repository.BookmarkRepository;
import com.example.goodyday.repository.MissionRepository;
import com.example.goodyday.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, UserRepository userRepository, MissionRepository missionRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.userRepository = userRepository;
        this.missionRepository = missionRepository;
    }

    @Override
    @Transactional
    public Bookmark createBookmark(String deviceId, String missionTitle) {
        User user = userRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Mission mission = missionRepository.findByTitle(missionTitle)
                .orElseThrow(() -> new RuntimeException("Mission not found"));
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setMission(mission);
        return bookmarkRepository.save(bookmark);
    }

    @Override
    @Transactional
    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bookmark> findBookmarksByDeviceId(String deviceId) {
        return bookmarkRepository.findByUser_DeviceId(deviceId);
    }
}