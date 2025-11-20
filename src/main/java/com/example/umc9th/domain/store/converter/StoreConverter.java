package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.dto.StoreReqDto;
import com.example.umc9th.domain.store.dto.StoreResDto;
import com.example.umc9th.domain.store.entity.Store;

import java.time.LocalDateTime;

public class StoreConverter {

    // DTO -> Entity (리뷰 저장용)
    public static Review toReview(StoreReqDto.ReviewDTO request, Member member, Store store) {
        return Review.builder()
                .content(request.getBody())
                .star(request.getScore())
                .member(member)
                .store(store)
                .build();
    }

    // Entity -> DTO (응답용)
    public static StoreResDto.CreateReviewResultDto toCreateReviewResultDTO(Review review) {
        return StoreResDto.CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now()) // 또는 review.getCreatedAt()
                .build();
    }
}