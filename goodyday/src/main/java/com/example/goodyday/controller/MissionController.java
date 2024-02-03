package com.example.goodyday.controller;

import com.example.goodyday.dto.MissionDto;
import com.example.goodyday.model.Mission;
import com.example.goodyday.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public ResponseEntity<Mission> createMission(@RequestBody MissionDto missionDto) {
        Mission newMission = missionService.createMission(new Mission(missionDto.getTitle(), missionDto.getGuideText(), missionDto.getContent(), missionDto.getPhoto_url(), missionDto.getLevel()), missionDto.getDeviceId());
        return ResponseEntity.ok(newMission);
    }

    @GetMapping("/user/{deviceId}")
    public ResponseEntity<List<Mission>> getMissionsByDeviceId(@PathVariable String deviceId) {
        List<Mission> missions = missionService.getMissionsByDeviceId(deviceId);
        return ResponseEntity.ok(missions);
    }

    @GetMapping
    public ResponseEntity<List<Mission>> getAllMissions() {
        List<Mission> missions = missionService.getAllMissions();
        return ResponseEntity.ok(missions);
    }
}
