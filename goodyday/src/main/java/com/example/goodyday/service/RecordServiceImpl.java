package com.example.goodyday.service;

import com.example.goodyday.model.Record;
import com.example.goodyday.repository.RecordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Record getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found with id " + id));
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    // 구현이 안됨
    public Record updateRecord(Long id, Record recordDetails) {
        return null;
    }


    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    @Override
    public List<Record> getRecordsByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }
}