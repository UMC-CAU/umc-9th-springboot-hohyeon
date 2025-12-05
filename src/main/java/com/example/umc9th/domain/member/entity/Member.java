package com.example.umc9th.domain.member.entity;


import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.SocialType;
import com.example.umc9th.domain.mission.entity.MemberMission;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.global.auth.enums.Role;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
/*
import jakarta.persistence.*;:
**JPA(Java Persistence API)**의 핵심 기능들을 가져옵니다.
@Entity, @Id, @Column 등 데이터베이스와 관련된 대부분의 어노테이션이 여기에 포함되어 있습니다.
(javax.persistence.*에서 이름이 변경되었습니다.)
 */
import lombok.*;
/*
import lombok.*;:
Lombok 라이브러리의 기능들을 가져옵니다.
@Getter, @Builder 등 반복적인 코드를 줄여주는 어노테이션들이 포함되어 있습니다.
 */
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="member")

// 이름/성별/생년월일/주소/상세주소/소설UID/소셜 타입/포인트/이메일/전화번호
// 삭제일자/수정일자는 BaseEntity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name= "birth")
    private LocalDate birth;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "social_uid")
    private String socialUid;

    @Column(name = "social_type")
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "point")
    private Integer point;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Member(1) to MemberMission(N)
    // mappedBy = "member"
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    // Member(1) to Review(N)
    // mappedBy = "member"
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    // Member(1) to MemberFood
    // mappedBy = "member"
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberFood> memberFoodList = new ArrayList<>();


}
