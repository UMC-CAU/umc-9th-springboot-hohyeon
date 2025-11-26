package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회 전용이므로 readOnly = true (성능 최적화)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override // 인터페이스의 메서드를 구현함
    public MyPageResponseDto getMyPageInfo(Long loggedInMemberId) {
        Member member = memberRepository.findById(loggedInMemberId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 사용자가 없습니다."));

        return MemberConverter.toMyPageDto(member);
    }

}