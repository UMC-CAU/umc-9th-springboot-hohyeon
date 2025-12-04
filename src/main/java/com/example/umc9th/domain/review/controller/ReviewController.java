package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayLoad.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor // (3) final 필드를 위한 생성자 자동 생성

public class ReviewController implements ReviewControllerDocs {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<Review> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception {
        //서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(filter, type);
        return result;
    }

    // 가게의 리뷰 목록 조회
    @GetMapping("/store-reviews")
    public ApiResponse<ReviewResDto.ReviewPreViewListDto> getStoreReviews(
            @RequestParam String storeName,
            @RequestParam Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findStoreReview(storeName,page));
    }
    @GetMapping("/my-reviews")
    public ApiResponse<ReviewResDto.ReviewPreViewListDto> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findMyReview(memberId,page));
    }
}
