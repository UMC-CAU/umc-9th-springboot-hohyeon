package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayLoad.code.BaseErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}