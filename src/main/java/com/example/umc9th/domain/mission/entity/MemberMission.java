package com.example.umc9th.domain.mission.entity;


import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.SocialType;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
/*
import jakarta.persistence.*;:
**JPA(Java Persistence API)**의 핵심 기능들을 가져옵니다.
@Entity, @Id, @Column 등 데이터베이스와 관련된 대부분의 어노테이션이 여기에 포함되어 있습니다.
(javax.persistence.*에서 이름이 변경되었습니다.)
 */
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
/*
import lombok.*;:
Lombok 라이브러리의 기능들을 가져옵니다.
@Getter, @Builder 등 반복적인 코드를 줄여주는 어노테이션들이 포함되어 있습니다.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="member_mission")

public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_complete")
    private boolean isComplete;

    // MemberMission(M) to Member(1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // MemberMission(M) to Mission(1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
