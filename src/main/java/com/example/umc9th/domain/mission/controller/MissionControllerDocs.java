package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MissionControllerDocs {
    // 가게의 리뷰 목록 조회
    @Operation(
            summary = "특정 가게의 미션 목록 조회 API",
            description = "특정 가게의 미션을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResDto.MissionPreViewListDto> getStoreMissions(Long storeId, Integer page);
}
