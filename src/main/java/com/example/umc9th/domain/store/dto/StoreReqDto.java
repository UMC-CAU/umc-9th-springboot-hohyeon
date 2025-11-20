package com.example.umc9th.domain.store.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
public class StoreReqDto {
    @Getter
    public static class ReviewDTO {
        @NotBlank
        private String title;

        @NotNull
        private Float score;

        @NotBlank
        private String body;

        @NotNull
        private Long memberId; // (로그인 구현 전이라 임시로 받음)
    }
}
