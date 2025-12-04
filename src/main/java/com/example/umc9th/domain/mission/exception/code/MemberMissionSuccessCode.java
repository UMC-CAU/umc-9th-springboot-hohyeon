package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum MemberMissionSuccessCode implements BaseSuccessCode {
    FOUND(HttpStatus.FOUND,
            "MEMBER_MISSION200",
            "해당 미션을 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
