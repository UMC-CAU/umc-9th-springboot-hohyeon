package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor // Builder가 생성자를 호출하기 위해 필요
public class MissionPreviewDto {

    // 1. "미션 도전!" 버튼을 누를 때 어떤 미션인지 식별하기 위한 ID
    /*
    missionId가 필요한 이유?
    missionId는 그 미션의 **"고유 식별 번호표"**이기 때문입니다.
    사용자가 화면에서 "미션 도전!" 버튼을 누르는 순간, 클라이언트(앱)는 서버에게 **"저, '어떤' 미션을 시작할게요!"**라고 요청을 보내야 합니다.
    이때, 서버가 '어떤' 미션인지 구별할 수 있게 해주는 유일한 값이 바로 missionId입니다.
     */
    private Long id;

    // 2. 가게 이름 (예: "반이학생마라탕")
    private String storeName;

    // 3. 미션 내용 (예: "10,000원 이상의 식사")
    private String content;

    // 4. 보상 (예: 500P)
    private Integer point;

}