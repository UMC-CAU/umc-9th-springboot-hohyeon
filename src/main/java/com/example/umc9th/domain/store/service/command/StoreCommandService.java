package com.example.umc9th.domain.store.service;

import com.example.umc9th.domain.store.dto.StoreReqDto;
import com.example.umc9th.domain.review.entity.Review;

public interface StoreCommandService {
    Review createReview(Long storeId, StoreReqDto.ReviewDTO request);
}