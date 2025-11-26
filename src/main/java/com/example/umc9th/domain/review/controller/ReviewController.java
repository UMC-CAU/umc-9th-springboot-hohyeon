package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;

public class ReviewController {
    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDto.ReviewPreViewListDto> getReviews(){

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, null);
    }
}
