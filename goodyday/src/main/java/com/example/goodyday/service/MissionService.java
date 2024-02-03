package com.example.goodyday.service;

import com.example.goodyday.model.Mission;

import java.util.List;

public interface MissionService {
    Mission createMission(Mission mission, String deviceId);
    List<Mission> getMissionsByDeviceId(String deviceId);
    List<Mission> getAllMissions();

}
