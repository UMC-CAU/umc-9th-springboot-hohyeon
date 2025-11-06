package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository; // Repository Import
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate; // Predicate Import
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service; // @Service Import
import org.springframework.transaction.annotation.Transactional; // Transaction Import

// Q클래스 static import
import static com.example.umc9th.domain.review.entity.QReview.review;

@Service // 이 클래스가 Service Bean임을 선언
@RequiredArgsConstructor // final Repository를 주입받기 위함
@Transactional(readOnly = true) // 조회 전용 서비스이므로 readOnly
public class ReviewQueryService {

    // Repository 주입 (QueryDSL 기능이 합쳐진)
    private final ReviewRepository reviewRepository;

    // 작성한 메서드 완성
    public Page<Review> findMyReview(Member member, Long storeId, Integer rating, Pageable pageable) {

        // Predicate(동적 조건) 조립 (아래 private 메서드 호출)
        Predicate predicate = buildDynamicPredicate(member, storeId, rating);

        // Repository에 완성된 '조건'과 '페이징'을 전달하여 호출
        // (이 findMyReview는 Repository의 QueryDSL 구현체에 있는 메서드입니다)
        return reviewRepository.findMyReview(predicate, pageable);
    }

    /*
     * 동적 쿼리 조건(Predicate)을 생성하는 헬퍼 메서드
     */
    private Predicate buildDynamicPredicate(Member member, Long storeId, Integer rating) {
        BooleanBuilder builder = new BooleanBuilder();

        // 1. 기본 조건: 내가 쓴 리뷰
        // QReview.review.member... 대신 static import한 review.member... 사용
        builder.and(review.member.eq(member));

        // 2. 동적 조건 1: 가게 ID (null이 아닐 때만 조건 추가)
        if (storeId != null) {
            builder.and(review.store.id.eq(storeId));
        }

        // 3. 동적 조건 2: 별점대 (null이 아닐 때만 조건 추가)
        if (rating != null) {
            if (rating == 5) {
                // 5점은 5.0만
                builder.and(review.star.eq(5.0f));
            } else if (rating > 0 && rating < 5) {
                // 4점대는 4.0 이상 ~ 5.0 미만
                builder.and(review.star.goe(rating.doubleValue())
                        .and(review.star.lt(rating.doubleValue() + 1)));
            }
            // (3점대, 2점대 등도 같은 방식으로 추가)
        }

        return builder; // 👈 완성된 Predicate (WHERE 조건절) 반환
    }
}