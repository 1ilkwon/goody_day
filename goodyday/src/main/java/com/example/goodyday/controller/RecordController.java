package com.example.goodyday.controller;

import com.example.goodyday.dto.RecordDto;
import com.example.goodyday.model.Record;
import com.example.goodyday.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Record> createRecord(@RequestBody RecordDto recordDto) {
        Record record = recordService.createRecord(recordDto);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{deviceId}")
    public ResponseEntity<List<Record>> getRecordsByDeviceId(@PathVariable String deviceId) {
        List<Record> records = recordService.findRecordsByDeviceId(deviceId);
        return ResponseEntity.ok(records);
    }
}

