package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory; // JPAQueryFactory import
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Pageable import
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

// Q클래스 static import (코드 간결화)
import static com.example.umc9th.domain.review.entity.QReview.review;
import static com.example.umc9th.domain.store.entity.QStore.store;

@RequiredArgsConstructor // final 필드 주입을 위해 @RequiredArgsConstructor 유지
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    // EntityManager 대신 JPAQueryFactory를 직접 주입
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Review> findMyReview(Predicate predicate, Pageable pageable) {

        // JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // QReview review = QReview.review; (static import로 대체)

        // Content 쿼리
        List<Review> content = queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(predicate)
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // Count 쿼리
        Long count = queryFactory
                .select(review.count())
                .from(review)
                .join(review.store, store)
                .where(predicate)
                .fetchOne();

        // Page 객체 생성
        return PageableExecutionUtils.getPage(content, pageable, () -> count);
    }
}