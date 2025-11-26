package com.example.umc9th.domain.member.exception;

import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
