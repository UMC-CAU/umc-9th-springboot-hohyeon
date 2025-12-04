package com.example.umc9th.domain.mission.exception;

import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
