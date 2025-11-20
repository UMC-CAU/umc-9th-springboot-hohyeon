package com.example.umc9th.domain.mission.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionReqDto {

    @Getter
    public static class JoinDto {
        @NotNull
        private Long missionId; // 도전하려는 미션 ID
    }
}