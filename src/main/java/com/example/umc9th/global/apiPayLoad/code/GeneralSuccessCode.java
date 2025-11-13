package com.example.umc9th.global.apiPayLoad.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    // --- 성공(Success) 관련 응답 코드 ---
    // 1. 가장 일반적인 성공 (200 OK)
    // - GET 요청 (조회) 성공 시
    // - PUT, PATCH 요청 (수정) 성공 시
    // - DELETE 요청 성공 시 (내용을 반환할 때)
    OK(HttpStatus.OK, "COMMON200_1", "요청에 성공했습니다."),
    // 2. 생성 성공 (201 Created)
    // - POST 요청 (생성) 성공 시 (예: 회원가입, 리뷰 작성)
    CREATED(HttpStatus.CREATED, "COMMON201_1", "요청 처리에 성공했으며, 리소스가 성공적으로 생성되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}