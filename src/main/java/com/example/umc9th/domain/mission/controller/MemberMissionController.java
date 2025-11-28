package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.dto.*;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.exception.code.MemberMissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MemberMissionCommandService;
import com.example.umc9th.domain.mission.service.query.MemberMissionQueryService;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions") // ✅ 주소 분리!
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    /**
     * 1. 미션 도전하기 API
     * [POST] /member-missions
     */
    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResDto.JoinResultDto> challengeMission(
            @RequestBody @Valid MemberMissionReqDto.JoinDto request
    ) {
        Long memberId = 1L;
        MemberMission memberMission = memberMissionCommandService.challengeMission(request, memberId);
        MemberMissionResDto.JoinResultDto resultDto = MemberMissionConverter.toJoinResultDto(memberMission);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, resultDto);
    }

    /**
     * 2. 내가 진행중/완료한 미션 목록 조회 API
     * [GET] /member-missions?isComplete=false&page=0
     */
    @GetMapping("/check-my-mission")
    public ApiResponse<Page<MemberMissionResponseDto>> getMyMissions(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(name = "isComplete") boolean isComplete,
            @RequestParam(name = "page") Integer page
    ) {
        // Long memberId = 1L;
        Page<MemberMissionResponseDto> myMissionPage = memberMissionQueryService.getMyMissions(memberId, isComplete, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myMissionPage);
    }

    /**
     * 3. 내가 진행중인 미션 목록 조회 API
     */
    @GetMapping("/check-mission-notComplete")
    public ApiResponse<MemberMissionResDto.MyMissionPreViewListDto> getMyMissionList(
            @RequestParam Long memberId,
            //@RequestParam boolean isComplete,
            @RequestParam Integer page
    ){
        MemberMissionSuccessCode code = MemberMissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, memberMissionQueryService.getMyMissionList(memberId,false,page));
    }
}