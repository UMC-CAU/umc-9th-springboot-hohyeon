package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionResultDto {
        private Long missionId;
        private LocalDateTime createdAt;
    }

    // 1. 미션 목록 조회 결과 (페이징 정보 + 미션 리스트)
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDto {
        private List<MissionPreViewDto> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    // 2. 개별 미션 정보
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDto {
        private Long missionId;
        private Integer point;
        private LocalDate deadline;
        private String conditional;
    }
}
