package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {

    // result -> DTO
    public static ReviewResDto.ReviewPreViewListDto toReviewPreviewListDto(
            Page<Review> result
    ){
        return ReviewResDto.ReviewPreViewListDto.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDto)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDto.ReviewPreViewDto toReviewPreviewDto(
            Review review
    ){
        return ReviewResDto.ReviewPreViewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStar())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }
}
