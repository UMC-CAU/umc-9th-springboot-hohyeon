package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayLoad.code.BaseSuccessCode; // 👈 BaseSuccessCode import
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode { // 👈 implements BaseSuccessCode

    // 1. 가게의 리뷰 목록 조회 성공
    REVIEW_LIST_FOUND(HttpStatus.OK,
            "REVIEW200_1",
            "가게의 리뷰 목록을 성공적으로 조회했습니다."),

    // 2. 리뷰 작성 성공 (필요시 사용)
    REVIEW_CREATED(HttpStatus.CREATED,
            "REVIEW201_1",
            "리뷰가 성공적으로 작성되었습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}