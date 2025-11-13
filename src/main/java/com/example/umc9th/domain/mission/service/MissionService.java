package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter; // 1. Converter import
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // (1) 이 클래스가 Service임을 선언
@RequiredArgsConstructor // (2) final 필드 주입
@Transactional(readOnly = true) // (3) 조회 전용 (성능 최적화)
public class MissionService {

    // (4) 필요한 도구들 주입 (사서 2명)
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    // (5) "내가 진행중/완료한 미션 조회" 비즈니스 로직
    public Page<MemberMissionResponseDto> getMyMissions(Long memberId, boolean isComplete, Integer page) {

        // 1. 사용자 엔티티 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        // 2. 페이징 정보(Pageable) 객체 생성
        // (예: 0번 페이지부터 3개씩, id 기준 내림차순(최신순))
        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "id"));

        // 3. '미션 사서(Repository)'에게 DB 작업 요청
        // (이때 Repository의 @EntityGraph가 N+1 문제를 해결해 줌)
        Page<MemberMission> missionPage = memberMissionRepository.findByMemberAndIsComplete(member, isComplete, pageable);

        // 4. '포장 직원(Converter)'에게 엔티티 페이지를 DTO 페이지로 변환 요청
        return MissionConverter.toMyMissionDtoPage(missionPage);
    }
}