package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    // 회원가입
    @Override
    public MemberResDto.JoinDto signup(
            MemberReqDto.JoinDto dto
    ){
        return null;
    }
}