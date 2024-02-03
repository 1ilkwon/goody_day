package com.example.goodyday.controller;

import com.example.goodyday.model.Record;
import com.example.goodyday.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    // 생성
    public Record createRecord(@RequestBody Record record) {
        return recordService.createRecord(record);
    }

    @GetMapping("/{id}")
    // 특정 기록 아이디로 조회
    public Record getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }

    @GetMapping
    // 전체 기록 조회
    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    @PutMapping("/{id}")
    // 기록 업데이트
    public Record updateRecord(@PathVariable Long id, @RequestBody Record recordDetails) {
        return recordService.updateRecord(id, recordDetails);
    }

    @DeleteMapping("/{id}")
    // 기록 삭제
    public void deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }

    @GetMapping("/user/{userId}")
    // 유저 기록 조회
    public List<Record> getRecordsByUserId(@PathVariable Long userId) {
        return recordService.getRecordsByUserId(userId);
    }
}
