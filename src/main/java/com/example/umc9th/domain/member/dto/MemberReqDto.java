package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {
    public record JoinDto(
            String name,
            String nickname,
            // Gender -> Integer 로 변경
            Integer gender,
            LocalDate birth,
            String detailAddress,
            String email,
            String phoneNumber,
            List<Long> preferCategory
    ){}
}
