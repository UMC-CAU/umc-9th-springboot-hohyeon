package com.example.umc9th.domain.member.service.query;

// 1. 필요한 도구들 import
import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MyPageResponseDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // "이 클래스는 Service입니다"라고 Spring에게 알림
@RequiredArgsConstructor
@Transactional(readOnly = true) // 이 클래스의 메서드들은 기본적으로 '읽기 전용'임을 선언
public class MemberQueryServiceImpl implements MemberQueryService {

    // Repository를 주입받음
    private final MemberRepository memberRepository;

    // Controller가 호출할 "마이페이지 조회" 메서드
    public MyPageResponseDto getMyPageInfo(Long loggedInMemberId) {

        // Repository에게 ID로 사용자를 찾아달라고 요청 (findById는 Optional<Member> 반환)
        Member member = memberRepository.findById(loggedInMemberId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 사용자가 없습니다.")); // 예외 처리

        // Converter에게 엔티티를 DTO로 변환해달라고 요청
        return MemberConverter.toMyPageDto(member);
    }

    //  나중에 '쓰기' 작업(회원가입 등)을 만들 때는
    // @Transactional 어노테이션을 메서드에 별도로 붙여 'readOnly' 를 덮어쓴다.
    @Transactional(readOnly = true)
    public Member joinMember(Member newMember) {
        // 비즈니스 로직은 추후에 추가
        return memberRepository.save(newMember);
    }
}