package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.StoreReqDto;
import com.example.umc9th.domain.store.dto.StoreResDto;
import com.example.umc9th.domain.store.service.StoreCommandService;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    // API: 가게에 리뷰 추가
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResDto.CreateReviewResultDto> createReview(
            @RequestBody @Valid StoreReqDto.ReviewDTO request,
            @PathVariable(name = "storeId") Long storeId
    ) {
        Review review = storeCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, StoreConverter.toCreateReviewResultDTO(review));
    }
}