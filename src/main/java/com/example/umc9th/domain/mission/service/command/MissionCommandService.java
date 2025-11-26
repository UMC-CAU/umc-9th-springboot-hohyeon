package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.entity.Mission;

public interface MissionCommandService {
    Mission createMission(MissionReqDto.CreateMissionDto request);
}
