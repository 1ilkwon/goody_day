package com.example.goodyday.service;

import com.example.goodyday.dto.RecordDto;
import com.example.goodyday.model.Mission;
import com.example.goodyday.model.Record;
import com.example.goodyday.model.User;
import com.example.goodyday.repository.MissionRepository;
import com.example.goodyday.repository.RecordRepository;
import com.example.goodyday.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository, UserRepository userRepository, MissionRepository missionRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
        this.missionRepository = missionRepository;
    }

    @Override
    public Record createRecord(RecordDto recordDto) {
        User user = userRepository.findByDeviceId(recordDto.getDeviceId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with device ID: " + recordDto.getDeviceId()));
        Mission mission = missionRepository.findByTitle(recordDto.getMissionTitle())
                .orElseThrow(() -> new EntityNotFoundException("Mission not found with title: " + recordDto.getMissionTitle()));

        Record record = new Record();
        record.setUser(user);
        record.setMission(mission);
        record.setTitle(recordDto.getTitle());
        record.setContent(recordDto.getContent());
        record.setPhotoUrl(recordDto.getPhoto_Url());
        return recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Long recordId) {
        recordRepository.deleteById(recordId);
    }

    @Override
    public List<Record> findRecordsByDeviceId(String deviceId) {
        return recordRepository.findByUser_DeviceId(deviceId);
    }
}