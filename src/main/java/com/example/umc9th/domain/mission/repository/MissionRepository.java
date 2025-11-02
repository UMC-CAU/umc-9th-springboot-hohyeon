package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query(value = """
                   SELECT m FROM Mission m
                   JOIN FETCH m.store s
                   JOIN s.location l
                   WHERE l.name LIKE %:region% AND NOT EXISTS (
                       SELECT mm FROM MemberMission mm
                       WHERE mm.member = :member AND mm.mission = m
                   )
                   """,
            countQuery = """
                        SELECT count(m) FROM Mission m
                        JOIN m.store s
                        JOIN s.location l
                        WHERE l.name LIKE %:region% AND NOT EXISTS (
                            SELECT mm FROM MemberMission mm
                            WHERE mm.member = :member AND mm.mission = m
                        )
                        """)
    Page<Mission> findAvailableMissionsInRegion(
            @Param("member") Member member,
            @Param("region") String region,
            Pageable pageable
    );
}
