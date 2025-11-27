package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto; //  1. 새로운 DTO import
import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
                .conditional(mission.getConditional()) //  3. DTO의 conditional 필드 매핑
                .point(mission.getPoint())             //  4. DTO의 point 필드 매핑
                .isComplete(memberMission.isComplete()) //  5. DTO의 isComplete 필드 매핑
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

    public static Mission toMission(MissionReqDto.CreateMissionDto request, Store store) {
        return Mission.builder()
                .point(request.getPoint())
                .deadline(request.getDeadline().atStartOfDay()) // LocalDate -> LocalDateTime 변환
                .conditional(request.getConditional())
                .store(store)
                .build();
    }

    public static MissionResDto.CreateMissionResultDto toCreateMissionResultDto(Mission mission) {
        return MissionResDto.CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // Entity -> DTO (개별 변환)
    public static MissionResDto.MissionPreViewDto toMissionPreViewDto(Mission mission) {
        return MissionResDto.MissionPreViewDto.builder()
                .missionId(mission.getId())
                .point(mission.getPoint())
                .deadline(mission.getDeadline().toLocalDate())
                .conditional(mission.getConditional())
                .build();
    }

    // Page -> List DTO (목록 변환)
    public static MissionResDto.MissionPreViewListDto toMissionPreViewListDto(Page<Mission> missionList) {

        List<MissionResDto.MissionPreViewDto> missionPreViewDtoList = missionList.stream()
                .map(MissionConverter::toMissionPreViewDto)
                .collect(Collectors.toList());

        return MissionResDto.MissionPreViewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDtoList.size())
                .missionList(missionPreViewDtoList)
                .build();
    }

}