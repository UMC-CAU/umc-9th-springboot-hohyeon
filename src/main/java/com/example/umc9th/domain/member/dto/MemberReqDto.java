package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {
    public record JoinDto(
            @NotBlank
            String name,
            @NotBlank
            String nickname,
            @NotBlank
            String password, // 추가된 속성
            // Gender -> Integer 로 변경
            @NotNull
            Integer gender,
            @NotNull
            LocalDate birth,
            @NotNull
            String detailAddress,
            @Email
            String email,
            @NotNull
            String phoneNumber,
            List<Long> preferCategory
    ){}

    // 로그인
    public record LoginDto(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
}
