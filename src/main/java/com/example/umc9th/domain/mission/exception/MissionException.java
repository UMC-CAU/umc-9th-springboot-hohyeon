package com.example.umc9th.domain.mission.exception;

import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(MissionErrorCode errorCode) {
        super(baseErrorCode);
    }
}
