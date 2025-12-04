package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MissionPreviewDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import org.springframework.data.domain.Page;

public interface MemberMissionQueryService {
    // 내가 진행중/완료한 미션 조회
    MemberMissionResDto.MyMissionPreViewListDto getMyMissionList(Long memberId, boolean isComplete, Integer page);
    // 홈 화면 - 도전 가능한 미션 목록 조회
    Page<MissionPreviewDto> getAvailableMissions(Long memberId, String region, Integer page);
    Page<MemberMissionResponseDto> getMyMissions(Long memberId, boolean isComplete, Integer page);
}