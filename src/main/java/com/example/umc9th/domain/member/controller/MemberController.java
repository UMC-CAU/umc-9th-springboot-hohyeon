// domain/member/controller/MemberController.java (수정 후)
package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9th.domain.member.service.command.MemberCommandService;
import com.example.umc9th.domain.member.service.query.MemberQueryService;
import com.example.umc9th.global.apiPayLoad.ApiResponse; // 1. ApiResponse import
import com.example.umc9th.global.apiPayLoad.code.GeneralSuccessCode; // 2. 성공 코드 import
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;
    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.JoinDto> signUp(
            @RequestBody MemberReqDto.JoinDto dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signup(dto));
    }
    // "마이 페이지 조회" API
    @GetMapping("/me")
    // 반환 타입을 ApiResponse<MyPageResponseDto>로 변경
    public ApiResponse<MyPageResponseDto> getMyPage() {
        Long memberId = 1L; // (임시)

        //  Service는 기존 DTO를 그대로 반환
        MyPageResponseDto responseDto = memberQueryService.getMyPageInfo(memberId);

        // ApiResponse.onSuccess()로 '성공 포장'하여 최종 반환
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, responseDto);
    }
    // 로그인
    @PostMapping("/login")
    public ApiResponse<MemberResDto.LoginDto> login(
            @RequestBody @Valid MemberReqDto.LoginDto dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberQueryService.login(dto));
    }
}