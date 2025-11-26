package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc9th.domain.mission.dto.MissionPreviewDto;
import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회 전용 (성능 최적화)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<MemberMissionResponseDto> getMyMissions(Long memberId, boolean isComplete, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("사용자 없음"));
        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "id"));

        Page<MemberMission> missionPage = memberMissionRepository.findByMemberAndIsComplete(member, isComplete, pageable);
        return MissionConverter.toMyMissionDtoPage(missionPage);
    }

    @Override
    public Page<MissionPreviewDto> getAvailableMissions(Long memberId, String region, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("사용자 없음"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<Mission> missionPage = missionRepository.findAvailableMissionsInRegion(member, region, pageable);

        // 변환 로직 (Mission -> MissionPreviewDto)
        return missionPage.map(mission -> {
            // (필요시 D-Day 계산)
            return MissionPreviewDto.builder()
                    .id(mission.getId())
                    .storeName(mission.getStore().getName())
                    .conditional(mission.getConditional())
                    .point(mission.getPoint())
                    .build();
        });
    }
}