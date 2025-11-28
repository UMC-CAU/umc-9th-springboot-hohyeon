package com.example.umc9th.domain.mission.repository;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;

import com.example.umc9th.domain.mission.entity.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @EntityGraph(attributePaths = {"mission"}) //  N+1 문제 해결
    Page<MemberMission> findByMemberAndIsComplete(Member member, boolean isComplete, Pageable pageable);
    boolean existsByMemberAndMission(Member member, Mission mission);
}
