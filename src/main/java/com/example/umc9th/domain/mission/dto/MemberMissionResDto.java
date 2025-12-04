package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDto {
        private Long memberMissionId;
        private LocalDateTime createdAt;
    }

    @Builder
    public record MyMissionPreViewListDto (
            List<MyMissionPreViewDto> myMissionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MyMissionPreViewDto(
            Long memberMissionId,
            String storeName,
            String conditional,
            Integer point,
            String isComplete,
            LocalDate deadline
    ){}
}