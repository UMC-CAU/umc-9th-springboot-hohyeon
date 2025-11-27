package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.MissionResDto;

public interface MissionQueryService {
    MissionResDto.MissionPreViewListDto findStoreMission(Long storeId, Integer page);
}