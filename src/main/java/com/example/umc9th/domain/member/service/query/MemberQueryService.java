package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import jakarta.validation.Valid;

public interface MemberQueryService {
    // 메서드 이름과 파라미터, 반환 타입만 정의합니다. (껍데기)
    MyPageResponseDto getMyPageInfo(Long memberId);

    MemberResDto.LoginDto login(MemberReqDto.@Valid LoginDto dto);
}