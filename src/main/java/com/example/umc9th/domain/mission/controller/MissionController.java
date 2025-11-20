package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.service.command.MemberMissionCommandService;
import com.example.umc9th.domain.mission.service.query.MemberMissionQueryService;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MissionController {

    private final MemberMissionCommandService memberMissionCommandService; // 도전하기(생성) 담당
    private final MemberMissionQueryService memberMissionQueryService;     // 조회(읽기) 담당

    /**
     * 1. 미션 도전하기 API
     * [POST] /member-missions
     */
    @PostMapping
    public ApiResponse<MemberMissionResDto.JoinResultDto> challengeMission(
            @RequestBody @Valid MemberMissionReqDto.JoinDto request
    ) {
        // (로그인 구현 전이므로 임시 ID 사용)
        Long memberId = 1L;

        // 1. CommandService를 통해 도전 처리 (DB 저장) -> 엔티티 반환
        MemberMission memberMission = memberMissionCommandService.challengeMission(request, memberId);

        // 2. 엔티티를 응답 DTO로 변환 (Converter 사용)
        MemberMissionResDto.JoinResultDto resultDto = MemberMissionConverter.toJoinResultDto(memberMission);

        // 3. 성공 응답 반환 (CREATED: 201)
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resultDto);
    }

    /**
     * 2. 내가 진행중/완료한 미션 목록 조회 API
     * [GET] /member-missions?isComplete=false&page=0
     */
    @GetMapping
    public ApiResponse<Page<MemberMissionResponseDto>> getMyMissions(
            @RequestParam(name = "isComplete") boolean isComplete,
            @RequestParam(name = "page") Integer page
    ) {
        // (로그인 구현 전이므로 임시 ID 사용)
        Long memberId = 1L;

        // 1. QueryService를 통해 조회 (이미 DTO로 변환되어 나옴)
        Page<MemberMissionResponseDto> myMissionPage = memberMissionQueryService.getMyMissions(memberId, isComplete, page);

        // 2. 성공 응답 반환 (OK: 200)
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myMissionPage);
    }
}