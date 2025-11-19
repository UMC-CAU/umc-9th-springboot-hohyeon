package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;

import java.time.LocalDate;

public class MemberReqDto {
    public record JoinDto(
            String name,
            String nickname,
            Gender gender,
            LocalDate birth,
            String detailAddress,
            String email,
            String phoneNumber
    ){}
}
