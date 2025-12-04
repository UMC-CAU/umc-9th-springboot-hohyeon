package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
// Request: 클라이언트(앱)가 서버에게 데이터를 보낼 때 (예: 회원가입, 리뷰 작성) 사용하는 DTO
public class ReviewReqDto {

    // 클라이언트가 작성해서 보낼 내용
    private String content;
    private Float star;

}