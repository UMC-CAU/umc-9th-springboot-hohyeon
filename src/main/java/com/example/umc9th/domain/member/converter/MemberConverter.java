package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Gender;
// import com.example.umc9th.domain.member.dto.MemberSignUpRequestDto; // (회원가입 DTO 예시)

public class MemberConverter {

    /**
     * Entity -> DTO (마이페이지 조회 시)
     * Service가 조회한 Member 엔티티를 MyPageResponseDto로 변환(포장)합니다.
     */
    public static MyPageResponseDto toMyPageDto(Member member) {

        // Member 엔티티의 필드에서 DTO에 필요한 정보만 뽑아서
        // DTO의 빌더(Builder)에 넣어준다.
        return MyPageResponseDto.builder()
                .name(member.getName()) // (엔티티의 name을 DTO의 nickname에 매핑)
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .point(member.getPoint())
                .build();
    }

    /**
     * DTO -> Entity (회원가입 시)
     * Controller가 받은 MemberSignUpRequestDto를 Member 엔티티로 변환(조립)합니다.
     */

    public static Member toMember(MemberReqDto.JoinDto request) {

        // (성별 등 Enum 변환 로직이 필요하다면 여기서 처리)
        // 1. 여기서 switch 문으로 정수를 Enum으로 변환 (가장 직관적인 방법!)
        // 이걸 위해 MemberReqDto 에서 타입 일치를 위해 gender 형을 Integer 로 변경
        Gender gender = switch (request.gender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.OTHER;
            default -> null;
        };

        return Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .birth(request.birth())
                .detailAddress(request.detailAddress())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .point(0) // 초기 포인트 설정
                .build();
    }
    // Entity -> DTO
    public static MemberResDto.JoinDto toJoinDTO(Member member){
        return MemberResDto.JoinDto.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }
}