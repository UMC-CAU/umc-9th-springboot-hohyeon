package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.*;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;
    /*
     * 가게에 미션 추가하기 API
     * [POST] /missions
     */
    @PostMapping
    public ApiResponse<MissionResDto.CreateMissionResultDto> createMission(
            @RequestBody @Valid MissionReqDto.CreateMissionDto request
    ) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, MissionConverter.toCreateMissionResultDto(mission));
    }

    /*
     * 특정 가게의 미션 목록 조회 API
     */
    @GetMapping("/stores")
    public ApiResponse<MissionResDto.MissionPreViewListDto> getStoreMissions(
            @RequestParam Long storeId,
            @RequestParam Integer page
    ){
        MissionSuccessCode code = MissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, missionQueryService.findStoreMission(storeId, page));
    }

}