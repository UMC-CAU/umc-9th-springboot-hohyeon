package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.entity.MemberMission;

public interface MemberMissionCommandService {
    // 미션 도전하기
    MemberMission challengeMission(MemberMissionReqDto.JoinDto request, Long memberId);
}