package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MemberMissionControllerDocs {
    // 가게의 리뷰 목록 조회
    @Operation(
            summary = "내가 진행중인 미션 목록 조회 API",
            description = "내가 진행중인 미션을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResDto.ReviewPreViewListDto> getMyMissionList(Long memberId, Integer page);
}