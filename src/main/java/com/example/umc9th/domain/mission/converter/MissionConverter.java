package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto; // 👈 1. 새로운 DTO import
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    /**
     * '내가 쓴 미션' Entity -> DTO 변환 메서드
     * (Service의 .map() 내부에서 호출됩니다)
     * [수정됨]: MemberMissionResponseDto 스펙에 맞게 필드 매핑 변경
     */
    public static MemberMissionResponseDto toMyMissionDto(MemberMission memberMission) {

        // 1. 연관된 Mission 엔티티를 꺼냅니다.
        Mission mission = memberMission.getMission();

        // 2. DTO를 조립합니다.
        return MemberMissionResponseDto.builder()
                .conditional(mission.getConditional()) // 👈 3. DTO의 conditional 필드 매핑
                .point(mission.getPoint())             // 👈 4. DTO의 point 필드 매핑
                .isComplete(memberMission.isComplete()) // 👈 5. DTO의 isComplete 필드 매핑
                .build();
    }

    /**
     * '내가 쓴 미션' Page<Entity> -> Page<DTO> 변환 메서드
     * (Service에서 이 메서드를 호출합니다)`
     */
    public static Page<MemberMissionResponseDto> toMyMissionDtoPage(Page<MemberMission> missionPage) {

        // 6. .map()이 호출하는 메서드를 위에서 수정한 toMyMissionDto로 변경
        // (반환 타입도 Page<MemberMissionResponseDto>로 자동 변경됨)
        return missionPage.map(MissionConverter::toMyMissionDto);
    }
}