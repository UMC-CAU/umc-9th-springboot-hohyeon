package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReviewControllerDocs {
    // 가게의 리뷰 목록 조회
    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResDto.ReviewPreViewListDto> getStoreReviews(String storeName, Integer page);

    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 API",
            description = "내가 작성한 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResDto.ReviewPreViewListDto> getMyReviews(Long memberId,  Integer page);
}
