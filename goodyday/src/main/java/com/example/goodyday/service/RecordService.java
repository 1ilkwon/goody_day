package com.example.goodyday.service;
import com.example.goodyday.model.Record;

import java.util.List;

public interface RecordService {
    Record createRecord(Record record);
    Record getRecordById(Long id);
    List<Record> getAllRecords();
    Record updateRecord(Long id, Record recordDetails);
    void deleteRecord(Long id);
    List<Record> getRecordsByUserId(Long userId);
}
