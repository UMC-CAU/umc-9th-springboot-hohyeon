package com.example.umc9th.domain.mission.dto;

import lombok.Builder;

@Builder
public record MissionPreviewDto(
        Long id,
        String storeName,
        String conditional,
        Integer point
) {
    // record는 생성자, Getter, toString, equals, hashCode를 자동으로 생성합니다.
    // 따라서 별도의 코드가 필요 없습니다.
}