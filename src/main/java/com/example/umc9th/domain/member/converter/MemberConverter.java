package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.entity.Member;
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

    /*
     * DTO -> Entity (회원가입 시)
     * Controller가 받은 MemberSignUpRequestDto를 Member 엔티티로 변환(조립)합니다.
     */

//    public static Member toMember(MemberSignUpRequestDto request) {
//
//        // DTO의 데이터를 엔티티의 빌더(Builder)에 넣어줍니다.
//        return Member.builder()
//                .name(request.getName())
//                .gender(request.getGender())
//                .birth(request.getBirth())
//                .detailAddress(request.getDetailAddress())
//                .phoneNumber(request.getPhoneNumber())
//                .point(0) // (예: 신규 가입 포인트는 0으로 초기화)
//                // (socialUid, socialType 등은 소셜 로그인 로직에서 별도 처리)
//                .build();
//    }
}