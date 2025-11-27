package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryService {
    // 검색 API
    List<Review> searchReview(
            String filter,
            String type
    ) throws Exception;


    ReviewResDto.ReviewPreViewListDto findStoreReview(
            String storeName,
            Integer page
    );
}