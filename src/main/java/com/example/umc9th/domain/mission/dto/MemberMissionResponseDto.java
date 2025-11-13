package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// Response: 서버가 클라이언트에게 데이터를 응답할 때 사용하는 DTO
@Getter
@Builder
@AllArgsConstructor
public class MemberMissionResponseDto {
    private String conditional;
    private Integer point;
    private boolean isComplete;
    /*
    여기서 궁금한 점: conditional(미션조건) 하고 point는 Mission entity 필드에 있는데,
    isComplete는 MemberMission에 있다... 같이 써도 되는걸까?
    -Gemini 답변-
    "내가 진행중인 미션 보기" 화면은 이 두 정보를 합쳐야만 완성됩니다.
    (MemberMission에서) "내가 '진행중'인 미션이 있는데,"
    (Mission에서) "그 미션의 원본을 보니 '가게이름a에서 12,000원 이상 식사 시 500P' 구나!"
    이 작업은 Service 계층에서 Page<MemberMission>을 Page<DTO>로 변환(map)할 때 일어납니다.
     */
}
