// domain/member/controller/MemberController.java (수정 후)
package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.service.MemberService; // (Service 경로)
import com.example.umc9th.global.apiPayLoad.ApiResponse; // 1. ApiResponse import
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode; // 2. 성공 코드 import
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.JoinDto> signUp(
            @RequestBody MemberReqDto.JoinDto dto
    ){
        return null;
    }

    // "마이 페이지 조회" API
    @GetMapping("/me")
    // 3. 반환 타입을 ApiResponse<MyPageResponseDto>로 변경
    public ApiResponse<MyPageResponseDto> getMyPage() {
        Long memberId = 1L; // (임시)

        // 4. Service는 기존 DTO를 그대로 반환
        MyPageResponseDto responseDto = memberService.getMyPageInfo(memberId);

        // 5. ApiResponse.onSuccess()로 '성공 포장'하여 최종 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, responseDto);
    }
}