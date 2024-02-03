package com.example.goodyday.service;

import com.example.goodyday.model.Mission;
import com.example.goodyday.model.User;
import com.example.goodyday.repository.MissionRepository;
import com.example.goodyday.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Autowired
    public MissionServiceImpl(MissionRepository missionRepository, UserRepository userRepository) {
        this.missionRepository = missionRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Mission createMission(Mission mission, String deviceId) {
        User user = userRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("User not found with device ID: " + deviceId));
        mission.setCreator(user);
        return missionRepository.save(mission);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mission> getMissionsByDeviceId(String deviceId) {
        return missionRepository.findByCreator_DeviceId(deviceId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }
}
