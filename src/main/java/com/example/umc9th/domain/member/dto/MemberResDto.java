package com.example.umc9th.domain.member.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDto {
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createAt
    ){}
}
