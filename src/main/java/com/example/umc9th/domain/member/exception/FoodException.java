package com.example.umc9th.domain.member.exception;

import com.example.umc9th.domain.member.exception.code.FoodErrorCode;
import com.example.umc9th.global.apiPayLoad.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(FoodErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
