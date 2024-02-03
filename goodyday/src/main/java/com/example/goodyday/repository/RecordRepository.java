package com.example.goodyday.repository;

import com.example.goodyday.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);

}
