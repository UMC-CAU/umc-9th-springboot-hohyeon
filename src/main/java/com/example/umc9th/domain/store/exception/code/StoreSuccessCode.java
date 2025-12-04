package com.example.umc9th.domain.store.exception.code;

import com.example.umc9th.global.apiPayLoad.code.BaseSuccessCode; // 👈 BaseSuccessCode import
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode { // 👈 implements BaseSuccessCode

    // 1. 가게의 리뷰 목록 조회 성공
    FOUND(HttpStatus.OK,
            "STORE200",
            "가게를 성공적으로 조회했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}