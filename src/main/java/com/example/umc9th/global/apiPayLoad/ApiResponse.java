package com.example.umc9th.global.apiPayLoad;

import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.code.BaseSuccessCode;
import com.fasterxml.jackson.annotation.JsonProperty;
// Jackson 라이브러리입니다.
// Java 객체를 JSON 문자열로 변환하거나,
// JSON을 Java 객체로 변환할 때 사용하는 도구입니다.
// @JsonProperty가 이 도구의 기능입니다.
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
// 이 객체를 JSON으로 변환할 때, 필드의 순서를 "isSuccess", "code", "message", "result" 순서로 고정
public class ApiResponse<T> {
    // <T>는 **제네릭(Generic)**을 의미합니다.
    // "이 포장 상자(ApiResponse)는 어떤 타입(T)의 선물이든 담을 수 있다"는 뜻입니다.

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    @JsonProperty("code")
    private final String code;

    @JsonProperty("message")
    private final String message;

    @JsonProperty("result")
    private T result;

    // 성공한 경우 (result 포함)
    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code, T result) {
        return new ApiResponse<>(true, code.getCode(), code.getMessage(), result);
    }
    // 실패한 경우 (result 포함)
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, T result) {
        return new ApiResponse<>(false, code.getCode(), code.getMessage(), result);
    }
}
