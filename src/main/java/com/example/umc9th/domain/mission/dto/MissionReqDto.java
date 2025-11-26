package com.example.umc9th.domain.mission.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.time.LocalDate;

public class MissionReqDto {
    @Getter
    public static class CreateMissionDto {
        @NotNull
        private Long storeId; // 어느 가게에 미션을 추가할지
        @NotNull
        private Integer point;
        @NotNull
        private LocalDate deadline;
        @NotNull
        private String conditional;
    }
}
