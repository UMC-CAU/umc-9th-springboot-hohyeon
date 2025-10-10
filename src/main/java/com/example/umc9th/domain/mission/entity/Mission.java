package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.SocialType;
import com.example.umc9th.domain.store.entity.Store;
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
@Table(name="mission")

public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "deadline", nullable = false)
    private LocalDateTime deadline;

    @Column(name = "conditional")
    private String conditional;

    @Column(name = "point")
    private Integer point;

    // store과 연관관계 생각해볼 것
    // 한 store에 여러 미션이 있다...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;


//    // Mission(1) to MemberMission(N)
//    // 'mappedBy = "mission"' : MemberMission 엔티티에 있는 'mission' 필드가 연관관계의 주인임을 명시
//    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
//    private List<MemberMission> memberMissionList = new ArrayList<>();

}
