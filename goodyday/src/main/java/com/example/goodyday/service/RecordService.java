package com.example.goodyday.service;
import com.example.goodyday.dto.RecordDto;
import com.example.goodyday.model.Record;

import java.util.List;

public interface RecordService {
    Record createRecord(RecordDto recordDto);
    void deleteRecord(Long recordId);
    List<Record> findRecordsByDeviceId(String deviceId);
}
