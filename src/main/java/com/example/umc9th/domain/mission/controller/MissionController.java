// domain/mission/controller/MissionController.java (수정 후)
package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto; // 1. DTO import
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayLoad.ApiResponse; // 2. ApiResponse import
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode; // 3. 성공 코드 import
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page; // 4. Page import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my-missions")
public class MissionController {

    private final MissionService missionService;

    // "내가 진행중/완료한 미션 조회" API
    @GetMapping
    // 5. 반환 타입을 ApiResponse<Page<MyMissionResponseDto>>로 변경
    public ApiResponse<Page<MemberMissionResponseDto>> getMyMissions(
            @RequestParam(name = "isComplete") boolean isComplete,
            @RequestParam(name = "page") Integer page) {

        Long loggedInMemberId = 1L; // (임시)

        // 6. Service는 기존 DTO 페이지를 그대로 반환
        Page<MemberMissionResponseDto> myMissionPage = missionService.getMyMissions(loggedInMemberId, isComplete, page);

        // 7. ApiResponse.onSuccess()로 '성공 포장'하여 최종 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myMissionPage);
    }
}