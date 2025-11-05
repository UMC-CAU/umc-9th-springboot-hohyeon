package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
// Response: 서버가 클라이언트에게 데이터를 응답할 때 사용하는 DTO
public class MyPageResponseDto {
    private String name;
    private String email;
    private Integer point;
    private String phoneNumber;
    private List<Review> reviewList;
}
