package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ReviewQueryDsl {
    Page<Review> findMyReview(
            Predicate predicate,
            Pageable pageable
    );

}
