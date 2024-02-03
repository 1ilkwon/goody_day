package com.example.goodyday.repository;

import com.example.goodyday.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByCreator_DeviceId(String deviceId);

}
