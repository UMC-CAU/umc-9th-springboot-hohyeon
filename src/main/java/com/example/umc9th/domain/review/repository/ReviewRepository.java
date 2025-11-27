package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, Pageable pageable);
/*
feat/chapter5
리뷰 작성하는 쿼리에서 insert 를 구현한 쿼리를 작성하지 않아도 된다
ReviewRepository 인터페이스가 JpaRepository 를 상속받는 순간, Spring Data JPA 는
save(Review review) 라는 메서드를 이미 자동으로 제공
 */
}
