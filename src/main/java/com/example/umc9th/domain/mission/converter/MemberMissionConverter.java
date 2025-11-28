package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .isComplete(false) // 처음 도전하면 당연히 '진행중'
                .build();
    }

    public static MemberMissionResDto.JoinResultDto toJoinResultDto(MemberMission memberMission) {
        return MemberMissionResDto.JoinResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 개별 변환
    public static MemberMissionResDto.MyMissionPreViewDto toMyMissionPreViewDto(
            MemberMission memberMission
    ){
        return MemberMissionResDto.MyMissionPreViewDto.builder()
                .memberMissionId(memberMission.getId())
                .storeName(memberMission.getMission().getStore().getName()) // 가게 이름
                .conditional(memberMission.getMission().getConditional())   // 미션 내용 (필드명 확인 필요)
                .point(memberMission.getMission().getPoint())              // 포인트
                .isComplete(memberMission.isComplete() ? "완료" : "진행 중") // 상태 변환
                .deadline(memberMission.getMission().getDeadline().toLocalDate())
                .build();
    }
    // result -> DTO
    public static MemberMissionResDto.MyMissionPreViewListDto toMyMissionPreviewListDto(
            Page<MemberMission> result
    ){
        return MemberMissionResDto.MyMissionPreViewListDto.builder()
                .myMissionList(result.getContent().stream()
                        .map(MemberMissionConverter::toMyMissionPreViewDto)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
}